package com.coldraincn.laimihui.presenter;

/**
 * Created by hd on 2017/9/14.
 */



        import android.content.Context;
        import android.content.Intent;

        import com.coldraincn.laimihui.entity.BindPhone;
        import com.coldraincn.laimihui.service.DataManager;
        import com.coldraincn.laimihui.view.BaseView;
        import com.coldraincn.laimihui.view.ChangeInfoView;

        import io.reactivex.Observable;
        import io.reactivex.android.schedulers.AndroidSchedulers;
        import io.reactivex.annotations.NonNull;
        import io.reactivex.disposables.CompositeDisposable;
        import io.reactivex.observers.DisposableObserver;
        import io.reactivex.schedulers.Schedulers;

/**
 * Created by wjq91 on 2017/9/11.
 */

public class ChangeInfoPresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;


    private ChangeInfoView changeInfoView;
    private BindPhone mBindPhone;

    public ChangeInfoPresenter(Context mContext) {
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
        if (mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(BaseView view) {
        changeInfoView = (ChangeInfoView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void savePersonData(String token, String name, String idCard) {
        Observable<BindPhone> observable = manager.savePersonData(token, name,  idCard);
        DisposableObserver<BindPhone> observer = new DisposableObserver<BindPhone>() {
            @Override
            public void onNext(@NonNull BindPhone bindPhone) {
                mBindPhone = bindPhone;
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                changeInfoView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mBindPhone != null) {
                    changeInfoView.onSuccess(mBindPhone);
                }
            }
        };
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }


}
