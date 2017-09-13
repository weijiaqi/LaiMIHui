package com.coldraincn.laimihui.presenter;

import android.content.Context;
import android.content.Intent;

import com.coldraincn.laimihui.entity.AddAddress;
import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.Area;
import com.coldraincn.laimihui.entity.DeleteAddress;
import com.coldraincn.laimihui.entity.GetAddress;
import com.coldraincn.laimihui.entity.UpdateAddress;
import com.coldraincn.laimihui.service.DataManager;
import com.coldraincn.laimihui.view.AddressModifyView;
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

public class AddressModifyPresenter implements BasePresenter{
    private DataManager mManager;
    private Context mContext;
    private AddressModifyView mAddressModifyView;
    private CompositeDisposable mCompositeDisposable;
    private GetAddress mGetAddress;
    private UpdateAddress mUpdateAddress;
    private DeleteAddress mDeleteAddress;
    private Area mArea;

    public AddressModifyPresenter(Context mContext) {
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
        mAddressModifyView = (AddressModifyView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getAddress(String token, long addressid){
        Observable<GetAddress> observable= mManager.getAddress(token, addressid);
        DisposableObserver<GetAddress> observer = new DisposableObserver<GetAddress>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mAddressModifyView.onError("请求失败");
            }

            @Override
            public void onComplete() {
                if (mGetAddress != null){
                    if("OK".equals(mGetAddress.getStatus())) {
                        mAddressModifyView.onSuccess(mGetAddress);
                    }else {
                        mAddressModifyView.onError(mGetAddress.getData().toString());
                    }
                }
            }
            @Override
            public void onNext(GetAddress entity) {
                mGetAddress = entity;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
    public void updateAddress(String token, Address address){
        Observable<UpdateAddress> observable= mManager.updateAddress(token, address.getData().getObjectId(),
                address.getData().getReceiverName(), address.getData().getReceiverPhoneNo(),
                address.getData().getReceiverAddress(), address.getData().getIsDefault(), address.getData().getPostCode(),
                address.getData().getProvinceCode(), address.getData().getCityCode(),
                address.getData().getAreaCode());
        DisposableObserver<UpdateAddress> observer = new DisposableObserver<UpdateAddress>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mAddressModifyView.onError("修改失败");
            }

            @Override
            public void onComplete() {
                if (mUpdateAddress != null && "OK".equals(mUpdateAddress.getStatus())){
                    mAddressModifyView.onUpdateSuccess();
                }
            }
            @Override
            public void onNext(UpdateAddress data) {
                mUpdateAddress = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
    public void deleteAddress(String token, long addressid){
        Observable<DeleteAddress> observable= mManager.deleteAddress(token, addressid);
        DisposableObserver<DeleteAddress> observer = new DisposableObserver<DeleteAddress>() {
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mAddressModifyView.onError("删除失败");
            }

            @Override
            public void onComplete() {
                if (mDeleteAddress != null && "OK".equals(mDeleteAddress.getStatus())){
                    mAddressModifyView.onDeleteSuccess();
                }
            }
            @Override
            public void onNext(DeleteAddress data) {
                mDeleteAddress = data;
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
    public void getAreaData(String token, int pid, final AddressAddPresenter.AreaListener areaListener){
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
}
