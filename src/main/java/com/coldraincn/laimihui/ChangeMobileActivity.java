package com.coldraincn.laimihui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.presenter.BindeMobilePresenter;
import com.coldraincn.laimihui.view.ChangeMobileView;

public class ChangeMobileActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    private String token;
    private BindeMobilePresenter bindeMobilePresenter = new BindeMobilePresenter(this);
    private String code;
    private EditText tv_mobile;
    private EditText tv_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_mobile);
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        tv_mobile = (EditText) findViewById(R.id.tv_mobile);
        tv_code = (EditText) findViewById(R.id.tv_code);
        findViewById(R.id.btn_getCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(tv_mobile.getText())) {
                    Toast.makeText(ChangeMobileActivity.this, "电话号码不能为空！", Toast.LENGTH_LONG).show();
                } else {
                    bindeMobilePresenter.getCode(tv_mobile.getText().toString());
                }
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = tv_code.getText().toString();
                if (TextUtils.isEmpty(temp)) {
                    Toast.makeText(ChangeMobileActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (temp.equals(code)) {
                    bindeMobilePresenter.saveNewPhone(token, tv_mobile.getText().toString(), 16320885275460L);
                } else {
                    Toast.makeText(ChangeMobileActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bindeMobilePresenter.onCreate();
        bindeMobilePresenter.attachView(mobileView);
    }

    private ChangeMobileView mobileView = new ChangeMobileView() {
        @Override
        public void onSuccess(BindPhone bindPhone) {//{"status":"OK","data":"添加成功"}
            Log.e("onSuccess", bindPhone.getData() + "," + bindPhone.getStatus());
            Toast.makeText(ChangeMobileActivity.this, bindPhone.getData(), Toast.LENGTH_LONG).show();
            finish();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(ChangeMobileActivity.this, "请求失败，请重试！", Toast.LENGTH_LONG).show();
        }

        @Override
        public void oncode(MessageCode result) {
            code = result.getData();
        }
    };

}
