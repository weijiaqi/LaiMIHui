package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.BindcellView;
import com.coldraincn.laimihui.view.SecondView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/9.
 */

public class SecondPresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private SecondView mSecondView;
    private ListMessage mListMessage;

    public SecondPresenter (Context mContext){
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
        mSecondView = (SecondView)view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void getlistMessage(String token,String phone){
        Observable<ListMessage> observable= manager.getlistMessage(token,phone);
        DisposableObserver<ListMessage> observer = new DisposableObserver<ListMessage>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mSecondView.onError("绑定失败");
            }

            @Override
            public void onComplete() {
                if (mListMessage != null){
                    mSecondView.onSuccess(mListMessage);
                }
            }



            @Override
            public void onNext(ListMessage data) {
                mListMessage = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

}
