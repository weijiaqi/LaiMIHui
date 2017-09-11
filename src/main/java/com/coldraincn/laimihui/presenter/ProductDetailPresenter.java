package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.ProductDetail;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.BindcellView;
import com.coldraincn.laimihui.view.ProductDetailView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/10.
 */

public class ProductDetailPresenter implements BasePresenter{
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private ProductDetailView mProductDetailView;
    private ProductDetail mProductDetail;

    public ProductDetailPresenter (Context mContext){
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
        mProductDetailView = (ProductDetailView)view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void productDetail(String token,String productOid){
        Observable<ProductDetail> observable= manager.productDetail(token,productOid);
        DisposableObserver<ProductDetail> observer = new DisposableObserver<ProductDetail>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mProductDetailView.onError("绑定失败");
            }

            @Override
            public void onComplete() {
                if (mProductDetail != null){
                    mProductDetailView.onSuccess(mProductDetail);
                }
            }



            @Override
            public void onNext(ProductDetail data) {
                mProductDetail = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

}
