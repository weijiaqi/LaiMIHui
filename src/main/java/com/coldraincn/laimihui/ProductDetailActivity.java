package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.coldraincn.laimihui.entity.ProductDetail;
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
    private String html="<p><img src=\"http://dev.wecity.co/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509989015007053.jpg\" title=\"1504509989015007053.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/></p>";
    @BindView(R.id.web)
    WebView web;
    private String token;
    private String productOid;
    private ProductDetail mProductDetail;

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.textViewname)
    TextView textViewname;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.paybutton)
    Button paybutton;

    @OnClick(R.id.paybutton)
    public void order() {
        Intent intent = new Intent(ProductDetailActivity.this, OrderconfirmActivity.class);

        Bundle bundle = new Bundle();

        bundle.putSerializable("productDetail", mProductDetail);
        bundle.putString("num","1");


        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }


   private ProductDetailPresenter mProductDetailPresenter = new ProductDetailPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
       //web.loadData(getHtmlData(html), "text/html; charset=UTF-8", null);
//        /////////获取数据
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "");
        Bundle bundle = this.getIntent().getExtras();

        productOid = bundle.getString("productOid");
        // textViewname.setText(productOid);
        mProductDetailPresenter.onCreate();
        mProductDetailPresenter.attachView(mProductDetailView);
        mProductDetailPresenter.productDetail(token, productOid);
       //  mProductDetailPresenter.productDetail(token,"533840800783484");

    }

    private ProductDetailView mProductDetailView = new ProductDetailView() {
        @Override
        public void onSuccess(ProductDetail data) {
            mProductDetail=data;
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
            textView5.setText(String.valueOf(data.getData().getShowSalePrice()) + "元");
            textView7.setText("限购" + String.valueOf(data.getData().getProductQuota()) + "份");
         //  web.loadData(getHtmlData(html), "text/html; charset=UTF-8", null);
           web.loadData(getHtmlData(data.getData().getProductInfo()), "text/html; charset=UTF-8", null);
        }

        @Override
        public void onError(String result) {

        }
    };

    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mProductDetailPresenter.onStop();
    }
}
