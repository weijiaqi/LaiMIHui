package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.HomeHoteData;
import com.coldraincn.laimihui.entity.Lactivity;
import com.coldraincn.laimihui.entity.Product;
import com.coldraincn.laimihui.entity.SeasonSell;
import com.coldraincn.laimihui.entity.SelectTopic;
import com.coldraincn.laimihui.entity.TodayExplosion;
import com.coldraincn.laimihui.entity.User;
import com.coldraincn.laimihui.entity.VipProduct;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.FirstView;
import com.coldraincn.laimihui.view.LoginView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hd on 2017/9/8.
 */

public class FirstPresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private FirstView mFirstView;

    private HomeHoteData mHomeHoteData;
    private Product mProduct;
    public FirstPresenter (Context mContext){
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
        mFirstView = (FirstView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
//    public void getActivityList(String token){
//        Observable<Lactivity> observable= manager.getActivityList(token);
//        DisposableObserver<Lactivity> observer = new DisposableObserver<Lactivity>() {
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//                mFirstView.onError("请求失败！！");
//            }
//
//            @Override
//            public void onComplete() {
//                if (mLactivity != null){
//                    //mFirstView.onSuccess(mLactivity);
//                    ArrayList images=getimages(mLactivity);
//                    mFirstView.onLoadActivityList(images);
//                }
//            }
//
//
//
//            @Override
//            public void onNext(Lactivity lactivity) {
//                mLactivity = lactivity;
//            }
//        };
//
//
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//        mCompositeDisposable.add(observer);
//    }
    private ArrayList getimages(Lactivity lactivity){
        ArrayList images=new ArrayList();
        for (int i = 0; i < lactivity.getData().size(); i++) {


            String url=lactivity.getData().get(i).getImg();


            images.add(url);
        }

        return images;
    }
    //    private ArrayList getimages1(TodayExplosion data){
//        ArrayList images=new ArrayList();
//        for (int i = 0; i < data.getData().size(); i++) {
//
//
//            String url=data.getData().get(i).getImg();
//
//
//            images.add(url);
//        }
//
//        return images;
//    }
    public void getHomeHoteList(String token){
        Observable<HomeHoteData> observable= manager.getHomeHoteList(token);
        DisposableObserver<HomeHoteData> observer = new DisposableObserver<HomeHoteData>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mFirstView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mHomeHoteData != null){
                    mFirstView.onSuccess7(mHomeHoteData);

                }
            }



            @Override
            public void onNext(HomeHoteData entity) {
                mHomeHoteData = entity;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
    public void getProductList(String token, String pageNo, String pageSize){
        Observable<Product> observable= manager.getProductList(token,pageNo,pageSize);
        DisposableObserver<Product> observer = new DisposableObserver<Product>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mFirstView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mProduct != null){
                    mFirstView.onSuccess6(mProduct);

                }
            }



            @Override
            public void onNext(Product entity) {
                mProduct = entity;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
}
