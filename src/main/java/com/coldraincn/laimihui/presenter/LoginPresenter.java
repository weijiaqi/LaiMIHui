package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.LoginView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/7.
 */

public class LoginPresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private LoginView mLoginView;
    private User mUser;
    private MessageCode mMessageCode;
    public LoginPresenter (Context mContext){
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
        mLoginView = (LoginView)view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void userLogin(String phone){
        Observable<User> observable= manager.userLogin(phone);
        DisposableObserver<User> observer = new DisposableObserver<User>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mLoginView.onError("登录失败");
            }

            @Override
            public void onComplete() {
                if (mUser != null){
                    mLoginView.onSuccess(mUser);
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
    public void getCode(String phone){
        Observable<MessageCode> observable= manager.getCode(phone);
        DisposableObserver<MessageCode> observer = new DisposableObserver<MessageCode>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mLoginView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mMessageCode != null){
                    mLoginView.oncode(mMessageCode);
                }
            }



            @Override
            public void onNext(MessageCode data) {
                mMessageCode = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
}
