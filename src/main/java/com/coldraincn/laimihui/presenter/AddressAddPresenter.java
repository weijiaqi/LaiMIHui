package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.AddAddress;
import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.Area;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.AddressAddView;
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

public class AddressAddPresenter implements BasePresenter{
    private DataManager mManager;
    private Context mContext;
    private AddressAddView mAddressAddView;
    private CompositeDisposable mCompositeDisposable;
    private Area mArea;
    private AddAddress mAddAddress;

    public AddressAddPresenter(Context mContext) {
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
        mAddressAddView = (AddressAddView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getAreaData(String token, int pid, final AreaListener areaListener){
        Observable<Area> observable= mManager.getAreaData(token, pid);
        DisposableObserver<Area> observer = new DisposableObserver<Area>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                if (mArea != null){
                    areaListener.success(mArea);
                }
            }
            @Override
            public void onNext(Area Area) {
                mArea = Area;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

    public void addAddress(String token, Address address){
        Observable<AddAddress> observable= mManager.addAddress(token, address.getData().getReceiverName(), address.getData().getReceiverPhoneNo(),
                address.getData().getReceiverAddress(), address.getData().getIsDefault(), address.getData().getPostCode(),
                address.getData().getProvinceCode(), address.getData().getCityCode(),
                address.getData().getAreaCode());
        DisposableObserver<AddAddress> observer = new DisposableObserver<AddAddress>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mAddressAddView.onError("");
            }

            @Override
            public void onComplete() {
                if (mAddAddress != null && "OK".equals(mAddAddress.getStatus())){
                    mAddressAddView.onAddSuccess();
                }
            }
            @Override
            public void onNext(AddAddress data) {
                mAddAddress = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

    public interface AreaListener{
        void success(Area area);
    }
}
