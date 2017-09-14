package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.DefaltAddress;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.createOrder;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.BindcellView;
import com.coldraincn.laimihui.view.OrderconfirmView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/12.
 */

public class OrderconfirmPresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private OrderconfirmView mOrderconfirmView;
    private DefaltAddress mAddress;
    private createOrder mcreateOrder;
    public OrderconfirmPresenter (Context mContext){
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
        mOrderconfirmView = (OrderconfirmView)view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void getDefaltAddress(String token){
        Observable<DefaltAddress> observable= manager.getDefaultAddress(token);
        DisposableObserver<DefaltAddress> observer = new DisposableObserver<DefaltAddress>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mOrderconfirmView.onError("绑定失败");
            }

            @Override
            public void onComplete() {
                if (mAddress != null){
                    mOrderconfirmView.onAddress(mAddress);
                }
            }



            @Override
            public void onNext(DefaltAddress data) {
                mAddress = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
    public void createOrder(String token, String productOid,String addressOid,String communityOid,
                            String tradeCount,String spbillCreateIp,String freight,String orderRemark){
        Observable<createOrder> observable= manager.createOrder(token,productOid,addressOid,communityOid,
                tradeCount,spbillCreateIp,freight,orderRemark);
        DisposableObserver<createOrder> observer = new DisposableObserver<createOrder>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mOrderconfirmView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mcreateOrder != null){
                    mOrderconfirmView.onCreateOrder(mcreateOrder);
                }
            }



            @Override
            public void onNext(createOrder data) {
                mcreateOrder = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
}
