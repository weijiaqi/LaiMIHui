package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
 * 完善资料信息界面
 */

public class InformationActivity extends AppCompatActivity {

    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.save)
    TextView save;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.shenfenzhenghao)
    EditText shenfenzhenghao;
    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.phone_number)
    EditText phoneNumber;
    @BindView(R.id.textView14)
    TextView textView14;
    @BindView(R.id.bind_phone)
    TextView bindPhone;
    @BindView(R.id.setname)
    TextView setname;
    private String name, idcard, phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_ziliao);
        ButterKnife.bind(this);
        titleName.setText("完善资料");
        save.setVisibility(View.VISIBLE);
        save.setText("保存");
        Intent intent=getIntent();
        setname.setText(intent.getStringExtra("username"));

        idcard = shenfenzhenghao.getText().toString();
        phone = phoneNumber.getText().toString();
        SharedPreferences sps=getSharedPreferences("information",MODE_PRIVATE);
        String idcard2=sps.getString("idcard","");
        String phone2=sps.getString("phone","");
        if (idcard2!=null){
            shenfenzhenghao.setText(idcard2);
        }
        if (phone2!=null){
            phoneNumber.setText(phone2);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (idcard.isEmpty()) {
                    Toast.makeText(InformationActivity.this, "身份证号不能为空", Toast.LENGTH_LONG).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(InformationActivity.this, "手机号不能为空", Toast.LENGTH_LONG).show();
                } else {
                    indate();
                }
            }
        });

    }

    public void indate() {
        String url = "http://api.17yun.com.cn/community/getCommunityListWithAgent.do";
        RequestBody formBody = new FormBody.Builder()
                .add("objectId", "1")
                .add("phone", phone)
                .add("idNumber", idcard)
                .build();
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InformationActivity.this, "保存成功", Toast.LENGTH_LONG).show();
                        String  shenfen=shenfenzhenghao.getText().toString();
                        String   shouji=phoneNumber.getText().toString();
                        SharedPreferences sp=getSharedPreferences("information",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("phone",shouji);
                        editor.putString("idcard",shenfen);
                        editor.commit();
                        Intent intent = new Intent(InformationActivity.this, PersronStoresActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}
