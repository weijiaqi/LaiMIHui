package com.coldraincn.laimihui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaySuccessActivity extends AppCompatActivity {

    @BindView(R.id.textView13)
    TextView textView13;
    @BindView(R.id.button7)
    Button button7;

    @OnClick(R.id.button7)
    public  void queding(){
        PaySuccessActivity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);
        ButterKnife.bind(this);
    }
}
