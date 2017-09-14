package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.entity.MyInfo;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/09/14.
 */

/**
 * 我的店铺
 */
public class PersronStoresActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.save)
    TextView save;
    @BindView(R.id.set_names)
    TextView setNames;
    @BindView(R.id.store_name)
    ImageButton storeName;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.attestation_info)
    ImageButton attestationInfo;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.button6)
    Button button6;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    String str = (String) msg.obj;
                    MyInfo myInfo = new Gson().fromJson(str, MyInfo.class);
                        MyInfo.DataBean dataBean = myInfo.getData();
                        String name = getIntent().getStringExtra("shopname");
                        if (name != null) {
                            setNames.setText(name);
                        } else {
                            setNames.setText(dataBean.getCommunityName()); //设置社区店名称
                        }

                        username.setText(dataBean.getShopKeeper());//设置认证信息
                        Picasso.with(PersronStoresActivity.this).load(dataBean.getQrCode()).placeholder(R.mipmap.yanzhengma).error(R.mipmap.yanzhengma).into(imageView5);

                    break;



            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_stores);
        ButterKnife.bind(this);
        storeName.setOnClickListener(this);
        attestationInfo.setOnClickListener(this);
        titleName.setText("我的店");


        String phone = getIntent().getStringExtra("phone");
        String idcard = getIntent().getStringExtra("idNumber");
        SharedPreferences sp = getSharedPreferences("wei", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("phone", phone);
        editor.putString("idcard", idcard);
        editor.commit();

        indata();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.store_name:
                Intent intent = new Intent(this, NameShopActivity.class);  //跳转修改店铺名称界面
                startActivity(intent);
                break;
            case R.id.attestation_info:
                String name = username.getText().toString();
                Intent intent2 = new Intent(this, InformationActivity.class);  //跳转完善资料界面
                intent2.putExtra("username", setNames.getText().toString());
                startActivity(intent2);
                break;

            default:
                break;
        }
    }

    public void indata() {
        String url = "http://api.17yun.com.cn/community/getCommunityInfo.do";
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("token", "4cd27a9172334ee9951c6900bfa06d2f")
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.e("Wei",str.toString());
                android.os.Message msg = android.os.Message.obtain();
                msg.obj = str;
                msg.what = 1;
                handler.sendMessage(msg);

            }
        });
    }
}
