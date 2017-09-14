package com.coldraincn.laimihui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.coldraincn.laimihui.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import common.Constants;

public class WeixinActivity extends AppCompatActivity {

    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.button)
    Button button;
    @OnClick(R.id.button)
    public void submit() {
       WXEntryActivity.loginWeixin(WeixinActivity.this, AppApplication.api);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);
        ButterKnife.bind(this);
        getSupportActionBar().hide();


    }

}
