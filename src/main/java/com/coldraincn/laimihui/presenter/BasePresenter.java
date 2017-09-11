package com.coldraincn.laimihui.presenter;

import android.content.Intent;

import com.coldraincn.laimihui.view.BaseView;

/**
 * Created by hd on 2017/9/7.
 */

public interface BasePresenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(BaseView view);

    void attachIncomingIntent(Intent intent);
}
