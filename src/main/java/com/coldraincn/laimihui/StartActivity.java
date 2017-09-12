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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   //全屏

            SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
            String token = settings.getString(PREF_CELL, "");
//
//
//        Intent intent = new Intent (StartActivity.this,OrderconfirmActivity.class);
//        startActivity(intent);
//        StartActivity.this.finish();




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


        }






}
