package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.presenter.BindcellPresenter;
import com.coldraincn.laimihui.presenter.LoginPresenter;
import com.coldraincn.laimihui.view.BindcellView;
import com.coldraincn.laimihui.view.LoginView;
import com.coldraincn.laimihui.widget.CountDownTimerButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BindcellActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    private String token;
    private String code;

    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.button4)
    CountDownTimerButton button4;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.button5)
    Button button5;
    @OnClick(R.id.button4)
    public void message() {
        if(TextUtils.isEmpty(editText.getText())){
            Toast.makeText(BindcellActivity.this, "电话号码不能为空！", Toast.LENGTH_LONG).show();
        }else{
            mBindcellPresenter.getCode(editText.getText().toString());
        }

    }
    @OnClick(R.id.button5)
    public void submit() {
        if(TextUtils.isEmpty(editText.getText())){
            Toast.makeText(BindcellActivity.this, "电话号码不能为空！", Toast.LENGTH_LONG).show();
        }else{
            if(editText3.getText().toString().equals(code)){
                mBindcellPresenter.bindPhone(token,editText.getText().toString());

            }else{
                Toast.makeText(BindcellActivity.this, "验证码不一致，请重新发送！", Toast.LENGTH_LONG).show();
            }

        }

    }
    private BindcellPresenter mBindcellPresenter = new BindcellPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindcell);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        mBindcellPresenter.onCreate();
        mBindcellPresenter.attachView(mBindcellView);
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "");
    }
    private BindcellView mBindcellView = new BindcellView() {
        @Override
        public void onSuccess(BindPhone mBindPhone) {
            SharedPreferences settings = BindcellActivity.this.getSharedPreferences(PREFUSER, 0);
            //获得可编辑对象
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(PREF_CELL, mBindPhone.getData());

            editor.apply();

            Intent intent = new Intent (BindcellActivity.this,MainActivity.class);
            startActivity(intent);
            BindcellActivity.this.finish();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(BindcellActivity.this, "手机注册失败！", Toast.LENGTH_LONG).show();
        }

        @Override
        public void oncode(MessageCode result) {
            code=result.getData();

        }
    };


    @Override
    public void onDestroy(){
        super.onDestroy();
        mBindcellPresenter.onStop();
    }

}
