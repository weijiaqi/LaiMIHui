package com.coldraincn.laimihui.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.coldraincn.laimihui.AppApplication;
import com.coldraincn.laimihui.BindcellActivity;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.presenter.WXPresenter;
import com.coldraincn.laimihui.view.WXView;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import org.json.JSONObject;

import common.Constants;
import common.LogUtil;
import common.ToastUtils;
import cz.msebera.android.httpclient.Header;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
	private static final String TAG = "WXEntryActivity";
	public static int types;
	public static final String PREFUSER = "USER";
	public static final String PREF_CELL = "CELL";
	public static final String PREF_TOKEN = "TOKEN";
	public static final String PREF_CID = "CID";
	private AsyncHttpClient client = new AsyncHttpClient();
	private WXPresenter mWXPresenter = new WXPresenter(this);

	private Gson mGson;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 微信事件回调接口注册
		AppApplication.api.handleIntent(getIntent(), this);
		mGson = new Gson();
		mWXPresenter.onCreate();
		mWXPresenter.attachView(mWXView);
	}


	/**
	 * 登录微信
	 *
	 * @param api 微信服务api
	 */
	public static void loginWeixin(Context context, IWXAPI api) {
		// 判断是否安装了微信客户端
		if (!api.isWXAppInstalled()) {
			Toast.makeText(context.getApplicationContext(), "您还未安装微信客户端！", Toast.LENGTH_SHORT).show();
			return;
		}
		// 发送授权登录信息，来获取code
		SendAuth.Req req = new SendAuth.Req();
		// 应用的作用域，获取个人信息
		req.scope = "snsapi_userinfo";
		/**
		 * 用于保持请求和回调的状态，授权请求后原样带回给第三方
		 * 为了防止csrf攻击（跨站请求伪造攻击），后期改为随机数加session来校验
		 */
		req.state = "app_wechat";
		api.sendReq(req);
		LogUtil.d(TAG, req.scope);
	}

	// 微信发送请求到第三方应用时，会回调到该方法
	@Override
	public void onReq(BaseReq req) {
		switch (req.getType()) {
			case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
				break;
			case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
				break;
			default:
				break;
		}
	}

	// 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
	@Override
	public void onResp(BaseResp resp) {
		switch (resp.errCode) {
			// 发送成功
			case BaseResp.ErrCode.ERR_OK:
				if (types == 2) {//分享
					ToastUtils.show(WXEntryActivity.this, "分享成功");
					finish();
				} else {//登录
					// 获取code
					String code = ((SendAuth.Resp) resp).code;
					LogUtil.d(TAG, "code:" + code);
					LogUtil.d(TAG, "state:" + ((SendAuth.Resp) resp).state);
					LogUtil.d(TAG, "lang:" + ((SendAuth.Resp) resp).lang);
					// 通过code获取授权口令access_token
					getAccessToken(code);
				}
				break;
		}
	}

	private void getAccessToken(String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
				"appid=" + Constants.APP_ID +
				"&secret=" + Constants.AppSecret +
				"&code=" + code +
				"&grant_type=authorization_code";
		client.get(url, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
				super.onSuccess(statusCode, headers, response);
				if (response != null) {
					try {
						String unionid = response.getString("unionid");
						String openid = response.getString("openid");
						String refresh_token = response.getString("refresh_token");
						String expires_in = response.getString("expires_in");
						String access_token = response.getString("access_token");

						System.out.println(unionid + "===" + openid + "===" + refresh_token + "===" + expires_in + "===" + access_token);


						client.get("https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token +
								"&openid=" + openid, new JsonHttpResponseHandler() {
							@Override
							public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
								super.onSuccess(statusCode, headers, response);

								if (response != null) {
									try {
										String nickname = response.getString("nickname");
										String sex = response.getString("sex");
										String province = response.getString("province");
										String city = response.getString("city");
										String country = response.getString("country");
										String headimgurl = response.getString("headimgurl");
										String unionid = response.getString("unionid");

										mWXPresenter.weixinLogin(nickname, sex, province, city, country, headimgurl, unionid);


									} catch (Exception e) {

									}
								}
							}
						});

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

	}


	private WXView mWXView = new WXView() {
		@Override
		public void onSuccess(User mUser) {
			SharedPreferences settings = WXEntryActivity.this.getSharedPreferences(PREFUSER, 0);
			//获得可编辑对象

			//获得可编辑对象
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(PREF_CELL, mUser.getData().getPhone());
			editor.putString(PREF_TOKEN, mUser.getData().getToken());
			editor.putString(PREF_CID, mUser.getData().getCommunityOid() + "");
			editor.apply();
//
//
//
			Intent intent = new Intent(WXEntryActivity.this, BindcellActivity.class);
			intent.putExtra("nickName", mUser.getData().getUserWxNickname());
			startActivity(intent);
			WXEntryActivity.this.finish();
		}

		@Override
		public void onError(String result) {
			Toast.makeText(WXEntryActivity.this, "登录失败，请重新登录！", Toast.LENGTH_LONG).show();
		}


	};


	@Override
	public void onDestroy() {
		super.onDestroy();
		mWXPresenter.onStop();
	}


}

