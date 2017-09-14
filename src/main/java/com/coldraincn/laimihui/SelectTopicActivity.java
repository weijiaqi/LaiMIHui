package com.coldraincn.laimihui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectTopicActivity extends AppCompatActivity {

    @BindView(R.id.selecttopic_webview)
    WebView selecttopicWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_topic);
        ButterKnife.bind(this);
        selecttopicWebview.loadUrl("https://www.baidu.com/");
    }
}
