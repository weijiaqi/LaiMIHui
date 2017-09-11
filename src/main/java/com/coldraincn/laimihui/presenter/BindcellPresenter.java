package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.BindcellView;
import com.coldraincn.laimihui.view.LoginView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/9.
 */


public class BindcellPresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private BindcellView mBindcellView;
    private BindPhone mBindPhone;
    private MessageCode mMessageCode;
    public BindcellPresenter (Context mContext){
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
        mBindcellView = (BindcellView)view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void bindPhone(String token,String phone){
        Observable<BindPhone> observable= manager.bindPhone(token,phone);
        DisposableObserver<BindPhone> observer = new DisposableObserver<BindPhone>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mBindcellView.onError("绑定失败");
            }

            @Override
            public void onComplete() {
                if (mBindPhone != null){
                    mBindcellView.onSuccess(mBindPhone);
                }
            }



            @Override
            public void onNext(BindPhone data) {
                mBindPhone = data;
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
                mBindcellView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mMessageCode != null){
                    mBindcellView.oncode(mMessageCode);
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

