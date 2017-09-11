package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.entity.ProductDetail;
import com.coldraincn.laimihui.presenter.FirstPresenter;
import com.coldraincn.laimihui.presenter.ProductDetailPresenter;
import com.coldraincn.laimihui.view.ProductDetailView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import common.GlideImageLoader;

public class ProductDetailActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    private String token;
    private String productOid;

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.textViewname)
    TextView textViewname;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.rv1)
    RecyclerView rv1;
    @BindView(R.id.paybutton)
    Button paybutton;
    @OnClick(R.id.paybutton)
    public void order() {
        Intent intent = new Intent (ProductDetailActivity.this,OrderconfirmActivity.class);
        startActivity(intent);
        this.finish();
    }



    private ProductDetailPresenter mProductDetailPresenter= new ProductDetailPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        /////////获取数据
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "");
        Bundle bundle = this.getIntent().getExtras();

        productOid = bundle.getString("productOid");
       // textViewname.setText(productOid);
        mProductDetailPresenter.onCreate();
        mProductDetailPresenter.attachView(mProductDetailView);
        mProductDetailPresenter.productDetail(token,productOid);
       // mProductDetailPresenter.productDetail("f74c0b1ac19c482e8a2364cf80e98296","533840800783484");

    }
    private ProductDetailView mProductDetailView=new ProductDetailView() {
        @Override
        public void onSuccess(ProductDetail data) {
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(data.getData().getImglist());
            banner.setBannerAnimation(Transformer.DepthPage);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(5000);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.CENTER);
            //banner设置方法全部调用完毕时最后调用
            banner.start();

            textViewname.setText(data.getData().getProductName());
            textView5.setText(String.valueOf(data.getData().getShowSalePrice())+"元");
            textView7.setText("限购"+String.valueOf(data.getData().getProductQuota())+"份");
        }

        @Override
        public void onError(String result) {

        }
    };
}
