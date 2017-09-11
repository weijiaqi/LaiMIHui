package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.LoginView;
import com.coldraincn.laimihui.view.WXView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/9.
 */

public class WXPresenter implements BasePresenter{
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private WXView mWXView;
    private User mUser;
    private MessageCode mMessageCode;
    public WXPresenter (Context mContext){
        this.mContext = mContext;
    }
    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeDisposable = new CompositeDisposable();

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(BaseView view) {
        mWXView = (WXView)view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void weixinLogin(String userWxNickname,String userSex,String userWxCountry,String userWxProvince,String userWxCity,String userWxHeadimgurl,String unionid){
        Observable<User> observable= manager.weixinLogin(userWxNickname,userSex,userWxCountry,userWxProvince,userWxCity,userWxHeadimgurl,unionid);
        DisposableObserver<User> observer = new DisposableObserver<User>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mWXView.onError("登录失败");
            }

            @Override
            public void onComplete() {
                if (mUser != null){
                    mWXView.onSuccess(mUser);
                }
            }



            @Override
            public void onNext(User user) {
                mUser = user;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

}
