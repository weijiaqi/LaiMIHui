package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.OrderList;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.BaseView;
import com.coldraincn.laimihui.view.OrdersView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class OrdersPresenter implements BasePresenter
{
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private OrdersView mOrdersView;
    private OrderList mOrderList;

    public OrdersPresenter(Context mContext)
    {
        this.mContext = mContext;
    }

    @Override
    public void onCreate()
    {
        manager = new DataManager(mContext);

        mCompositeDisposable = new CompositeDisposable();

    }

    @Override
    public void onStart()
    {

    }

    @Override
    public void onStop()
    {
        if (mCompositeDisposable.isDisposed())
        {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void attachView(BaseView view)
    {
        mOrdersView = (OrdersView) view;

    }

    @Override
    public void attachIncomingIntent(Intent intent)
    {

    }

    public void getUserOrderList(String token, String orderStatus)
    {
        Observable<OrderList> observable = manager.getUserOrderList(token, orderStatus);

        DisposableObserver<OrderList> observer = new DisposableObserver<OrderList>()
        {
            @Override
            public void onError(Throwable e)
            {
                e.printStackTrace();

                if (mOrdersView != null)
                {
                    mOrdersView.onError("请求失败！！");
                }
            }

            @Override
            public void onComplete()
            {
                if (mOrderList != null && mOrdersView != null)
                {
                    mOrdersView.onSuccess(mOrderList);
                }
            }


            @Override
            public void onNext(OrderList data)
            {
                mOrderList = data;
            }
        };

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

}
