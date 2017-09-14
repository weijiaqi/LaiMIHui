package com.coldraincn.laimihui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.coldraincn.laimihui.adapter.CommodityManagerAdapter;
import com.coldraincn.laimihui.entity.ShangPin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 2017/09/12. wjq
 * 商品管理
 */

public class CommodityManagerActivity extends AppCompatActivity {
    private CommodityManagerAdapter mAdapter;
    private List<ShangPin> lists;
    private ShangPin shangpin;
    @BindView(R.id.dity_manager)
    RecyclerView dityManager;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    String str = (String) msg.obj;
                    JSONObject jsonobj;
                    try {
                        jsonobj = new JSONObject(str);
                        JSONArray arrays = jsonobj.getJSONArray("data");
                        Log.e("wei", arrays.toString());
                        if (arrays.length() == 0) {
//                        Toast.makeText(CommodityManagerActivity.this, "没有下架产品", Toast.LENGTH_LONG).show();
                        } else {

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    String str2 = (String) msg.obj;
                    JSONObject jsonobj2;
                    try {
                        jsonobj2 = new JSONObject(str2);
                        JSONArray arrays = jsonobj2.getJSONArray("data");
                        Log.e("wei", arrays.toString());
                        if (arrays.length() == 0) {
                            Toast.makeText(CommodityManagerActivity.this, "没有更多数据了", Toast.LENGTH_LONG).show();
                        } else {
                            for (int i = 0; i < arrays.length(); i++) {
                                JSONObject item = arrays.optJSONObject(i); // 得到每个对象
                                String picture = item.optString("coverId");
                                String name = item.optString("productName");
                                String price = item.optString("showSalePrice");
                                String  object=item.optString("objectId");
//                             String communityBonus=item.getString("communityBonus");//收益
//                             String dianjinumber=item.getString("dianjinumber");
                                shangpin = new ShangPin();
                                shangpin.setPicture(picture);
                                shangpin.setName(name);
                                shangpin.setPrice(price);
                                shangpin.setObjectId(object);
//                             shangpin.setCommunityBonus(communityBonus);
//                             shangpin.setDianjinumber(dianjinumber);
                                lists.add(shangpin);
                            }
                            mAdapter.notifyDataSetChanged();
                            dityManager.setAdapter(mAdapter);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commodity_manager);
        ButterKnife.bind(this);
        lists = new ArrayList<ShangPin>();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dityManager.setLayoutManager(layoutManager);
        mAdapter = new CommodityManagerAdapter(this, lists);
        initData();
    }


    public void initData() {
        shangjia();
        xiajia();
        dityManager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    public void xiajia() {
        String url = "http://api.17yun.com.cn/community/getCommunityOutProductList.do";
        OkHttpClient mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("objectId", "1")
                .build();
        Request request = new Request.Builder()
                .addHeader("token", "1")
                .url(url)
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(CommodityManagerActivity.this, "错误" + e.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                android.os.Message msg = android.os.Message.obtain();
                msg.obj = str;
                msg.what = 1;
                handler.sendMessage(msg);
            }
        });


    }


    //获取上架产品
    public void shangjia() {

        String url = "http://api.17yun.com.cn/community/getCommunityProductList.do";

        OkHttpClient mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("objectId", "1")
                .build();
        Request request = new Request.Builder()
                .addHeader("token", "1")
                .url(url)
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(CommodityManagerActivity.this, "错误" + e.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 String str=response.body().string();
                android.os.Message msg = android.os.Message.obtain();
                msg.obj = str;
                msg.what = 2;
                handler.sendMessage(msg);

            }
        });

    }
}
