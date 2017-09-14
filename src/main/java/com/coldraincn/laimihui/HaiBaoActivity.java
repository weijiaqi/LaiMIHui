package com.coldraincn.laimihui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/09/14.
 */

public class HaiBaoActivity extends AppCompatActivity {
    @BindView(R.id.haibao1)
    ImageView haibao1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haibao);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String in=intent.getStringExtra("haibao");
        Picasso.with(this).load(in).into(haibao1);
    }
}
