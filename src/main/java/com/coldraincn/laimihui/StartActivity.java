package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

public class StartActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   //全屏

//        SharedPreferences settings = StartActivity.this.getSharedPreferences(PREFUSER, 0);
//        //获得可编辑对象
//        SharedPreferences.Editor editor = settings.edit();
//        editor.putString(PREF_CELL, "18661772011");
//        editor.putString(PREF_TOKEN, "1");
//        editor.putString(PREF_CID, "1");
//        editor.putString(PREF_USERROLE, "1");
//        editor.putString(PREF_IMAGE, "");
//        editor.putString(PREF_NAME, "1");
//        editor.apply();

//
//
//        Intent intent = new Intent (StartActivity.this,MainActivity.class);
//        startActivity(intent);
//        StartActivity.this.finish();



        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        String token = settings.getString(PREF_CELL, "");

            if (!"".equals(token)) {
                new Handler().postDelayed(new Runnable(){
                    public void run(){


                        Intent intent = new Intent (StartActivity.this,MainActivity.class);
                        startActivity(intent);
                        StartActivity.this.finish();
                    }
                }, 1000);

            }
            else {
                new Handler().postDelayed(new Runnable(){
                    public void run(){


                        Intent intent = new Intent(StartActivity.this,LoginActivity.class);
                        startActivity(intent);
                        StartActivity.this.finish();
                    }
                }, 1000);
            }
//
//
     }






}
