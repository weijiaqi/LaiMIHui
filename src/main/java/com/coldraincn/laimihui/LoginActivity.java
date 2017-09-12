package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.presenter.LoginPresenter;
import com.coldraincn.laimihui.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";
    private String cell;
    private String code;


    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button2)
    Button button2;
    @OnClick(R.id.button1)
    public void message() {
        if(TextUtils.isEmpty(editText1.getText())){
            Toast.makeText(LoginActivity.this, "电话号码不能为空！", Toast.LENGTH_LONG).show();
        }else{
            mLoginPresenter.getCode(editText1.getText().toString());
        }

    }
    @OnClick(R.id.button2)
    public void submit() {
        if(TextUtils.isEmpty(editText1.getText())){
            Toast.makeText(LoginActivity.this, "电话号码不能为空！", Toast.LENGTH_LONG).show();
        }else{
            if(editText2.getText().toString().equals(code)){
                mLoginPresenter.userLogin(editText1.getText().toString());

            }else{
                Toast.makeText(LoginActivity.this, "验证码不一致，请重新发送！", Toast.LENGTH_LONG).show();
            }

        }

    }
    @OnClick(R.id.button3)
    public void register() {
        Intent intent = new Intent (LoginActivity.this,WeixinActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }

    private LoginPresenter mLoginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // Set up the login form.
        mLoginPresenter.onCreate();
        mLoginPresenter.attachView(mLoginView);


    }


    private LoginView mLoginView = new LoginView() {
        @Override
        public void onSuccess(User mUser) {
            SharedPreferences settings = LoginActivity.this.getSharedPreferences(PREFUSER, 0);
            //获得可编辑对象
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(PREF_CELL, mUser.getData().getPhone());
            editor.putString(PREF_TOKEN, mUser.getData().getToken());
            editor.putString(PREF_CID, String.valueOf(mUser.getData().getCommunityOid()));
            editor.putString(PREF_USERROLE, String.valueOf(mUser.getData().getUserRole()));
            editor.putString(PREF_IMAGE, mUser.getData().getUserWxHeadimgurl());
            editor.putString(PREF_NAME, mUser.getData().getUserWxNickname());
            editor.apply();

            Intent intent = new Intent (LoginActivity.this,MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(LoginActivity.this, "登录失败，请重新登录！", Toast.LENGTH_LONG).show();
        }

        @Override
        public void oncode(MessageCode result) {
            code=result.getData();
            Log.e("message",code);

        }
    };


    @Override
    public void onDestroy(){
        super.onDestroy();
        mLoginPresenter.onStop();
    }


}

