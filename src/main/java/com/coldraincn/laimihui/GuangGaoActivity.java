package com.coldraincn.laimihui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/09/14.
 */

public class GuangGaoActivity extends AppCompatActivity {
    @BindView(R.id.guanggao)
    ImageView guanggao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guanggao);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String in=intent.getStringExtra("guanggaotwo");
        Log.e("weijiaqiaaaaa",in.toString());
        Picasso.with(this).load(in).into(guanggao);
    }
}
