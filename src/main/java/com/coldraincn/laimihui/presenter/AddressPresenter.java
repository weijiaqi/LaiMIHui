package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.AddressList;
import com.coldraincn.laimihui.entity.Product;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.AddressView;
import com.coldraincn.laimihui.view.BaseView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 13:32
 */

public class AddressPresenter implements BasePresenter{
    private DataManager mManager;
    private Context mContext;
    private AddressView mAddressView;
    private CompositeDisposable mCompositeDisposable;
    private AddressList mAddressList;

    public AddressPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
        mManager = new DataManager(mContext);
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
        mAddressView = (AddressView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getAddressList(String token){
        Observable<AddressList> observable= mManager.getAddressList(token);
        DisposableObserver<AddressList> observer = new DisposableObserver<AddressList>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mAddressView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mAddressList != null){
                    mAddressView.onSuccess(mAddressList);
                }
            }
            @Override
            public void onNext(AddressList entity) {
                mAddressList = entity;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
}
