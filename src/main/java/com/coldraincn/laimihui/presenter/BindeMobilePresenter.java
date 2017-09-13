package com.coldraincn.laimihui.presenter;

/**
 * Created by hd on 2017/9/14.
 */



        import android.content.Context;
        import android.content.Intent;

        import com.coldraincn.laimihui.entity.BindPhone;
        import com.coldraincn.laimihui.entity.MessageCode;
        import com.coldraincn.laimihui.service.DataManager;
        import com.coldraincn.laimihui.view.BaseView;
        import com.coldraincn.laimihui.view.ChangeMobileView;

        import io.reactivex.Observable;
        import io.reactivex.android.schedulers.AndroidSchedulers;
        import io.reactivex.annotations.NonNull;
        import io.reactivex.disposables.CompositeDisposable;
        import io.reactivex.observers.DisposableObserver;
        import io.reactivex.schedulers.Schedulers;

/**
 * Created by wjq91 on 2017/9/11.
 */

public class BindeMobilePresenter implements BasePresenter {
    private DataManager manager;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;
    private ChangeMobileView changeMobileView;
    private BindPhone mBindPhone;
    private MessageCode mMessageCode;

    public BindeMobilePresenter(Context mContext) {
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
        changeMobileView = (ChangeMobileView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void saveNewPhone(String token, String phone, long userId) {
        Observable<BindPhone> observable = manager.saveNewPhone(token, phone, userId, phone);
        DisposableObserver<BindPhone> observer = new DisposableObserver<BindPhone>() {
            @Override
            public void onNext(@NonNull BindPhone bindPhone) {
                mBindPhone = bindPhone;
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                changeMobileView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mBindPhone != null) {
                    changeMobileView.onSuccess(mBindPhone);
                }
            }
        };
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }

    public void getCode(String phone) {
        Observable<MessageCode> observable = manager.getCode(phone);
        DisposableObserver<MessageCode> observer = new DisposableObserver<MessageCode>() {
            @Override
            public void onNext(@NonNull MessageCode messageCode) {
                mMessageCode = messageCode;
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                changeMobileView.onError("请求失败！！");
            }

            @Override
            public void onComplete() {
                if (mMessageCode != null) {
                    changeMobileView.oncode(mMessageCode);
                }
            }
        };


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        mCompositeDisposable.add(observer);
    }
}
