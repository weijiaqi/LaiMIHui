package com.coldraincn.laimihui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

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
 * Created by Administrator on 2017/09/13.
 * //修改店铺名称
 */

public class NameShopActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.saves)
    Button saves;
    @BindView(R.id.shopname)
    EditText shopname;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_shop);
        ButterKnife.bind(this);
        titleName.setText("店铺名称");
        saves.setOnClickListener(this);


    }

    public void indata() {
        final String name = shopname.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(NameShopActivity.this, "名称不能为空", Toast.LENGTH_LONG).show();
        }
        String url = "http://api.17yun.com.cn/community/getCommunityListWithAgent.do";
        RequestBody formBody = new FormBody.Builder()
                .add("objectId", "1")
                .add("communityName", name)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .addHeader("token", "14ea6d26ae694136b1e2b0a69dd4145e")
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(NameShopActivity.this, "修改成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(NameShopActivity.this, PersronStoresActivity.class);
                        intent.putExtra("shopname", name);
                        startActivity(intent);
                    }
                });


            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saves:
                indata();
                break;
        }
    }
}
