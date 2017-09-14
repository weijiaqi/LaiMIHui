package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.coldraincn.laimihui.entity.ProductDetail;
import com.coldraincn.laimihui.presenter.ProductDetailPresenter;
import com.coldraincn.laimihui.view.ProductDetailView;
import com.coldraincn.laimihui.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import common.CommonUtils;
import common.GlideImageLoader;
import common.ToastUtils;

import static com.coldraincn.laimihui.AppApplication.api;
import static com.coldraincn.laimihui.LoginActivity.PREF_CID;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    private String html = "<p><img src=\"http://dev.wecity.co/task/ueditor/readImage.do?path=/home/thinker/wwwroot/dev.wecity.co/upload/image/20170904/1504509989015007053.jpg\" title=\"1504509989015007053.jpg\" style=\"width:100%;\" alt=\"微信图片_20170831101644.jpg\"/></p>";
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

    @BindView(R.id.iv_share)
    ImageView iv_share;
    private static final int THUMB_SIZE = 150;

    private PopupWindow popupWindow;
    private PopupWindow mpopupWindow;
    private int sum = 1;
    private int maxSum = 0;
    private LinearLayout layout_share_back;
    private ImageView img_share_haoyou, img_share_pengyou;

    @OnClick(R.id.iv_share)
    public void share() {
        if (!CommonUtils.isWeixinAvilible(this)) {//没装微信
            ToastUtils.show(this, "请先安装微信客户端");
        } else {
            showPopMenu();
        }
    }

    private void shareWX(int mTargetScene) {
        WXEntryActivity.types = 2;
        WXWebpageObject webpage = new WXWebpageObject();
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        String communityOid = settings.getString(PREF_CID, "");
        webpage.webpageUrl = "http://dev.wecity.co/task/mall/product/viewProductDetail.do?objectId=" + mProductDetail.getData().getObjectId() + "&communityOid=" + communityOid + "&forwardUserOid=" + communityOid;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = mProductDetail.getData().getProductName();
        msg.description = mProductDetail.getData().getShareDescribe();
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = bmpToByteArray(thumbBmp, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = mTargetScene;
        api.sendReq(req);
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void showPopMenu() {
        View view = View.inflate(getApplicationContext(), R.layout.deloge_share_wx, null);
        view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        LinearLayout ll_popup = (LinearLayout) view.findViewById(R.id.ll_share);

        ll_popup.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_bottom_in));

        img_share_haoyou = (ImageView) view.findViewById(R.id.img_deloge_share_haoyou);
        img_share_pengyou = (ImageView) view.findViewById(R.id.img_deloge_share_pengyou);

        layout_share_back = (LinearLayout) view.findViewById(R.id.layout_deloge_share_back);

        img_share_haoyou.setOnClickListener(this);
        img_share_pengyou.setOnClickListener(this);
        layout_share_back.setOnClickListener(this);


        if (mpopupWindow == null) {
            mpopupWindow = new PopupWindow(this);
            mpopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            mpopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            mpopupWindow.setBackgroundDrawable(new BitmapDrawable());

            mpopupWindow.setFocusable(true);
            mpopupWindow.setOutsideTouchable(true);
        }

        mpopupWindow.setContentView(view);
        mpopupWindow.showAtLocation(iv_share, Gravity.BOTTOM, 0, 0);
        mpopupWindow.update();
    }

    @OnClick(R.id.paybutton)
    public void order() {
        View view = View.inflate(getApplicationContext(), R.layout.dialog_select_num, null);
        ImageView iv_sub = view.findViewById(R.id.iv_sub);
        ImageView iv_add = view.findViewById(R.id.iv_add);
        TextView tv_product_name = view.findViewById(R.id.tv_product_name);
        TextView tv_product_price = view.findViewById(R.id.tv_product_price);
        tv_product_name.setText(mProductDetail.getData().getProductName());
        tv_product_price.setText("￥" + mProductDetail.getData().getShowSalePrice());


        View btn_buy = view.findViewById(R.id.btn_buy);
        View rl_bg = view.findViewById(R.id.rl_bg);
        rl_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final EditText tv_sum = view.findViewById(R.id.tv_sum);
        tv_sum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString().trim();
                if (s.length() > 0) {
                    sum = Integer.parseInt(s);
                }
            }
        });


        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sum < maxSum) {
                    sum++;
                } else {
                    ToastUtils.show(ProductDetailActivity.this, "限购" + maxSum + "份");
                }
                tv_sum.setText(sum + "");
            }
        });

        iv_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sum > 0)
                    sum--;
                tv_sum.setText(sum + "");
            }
        });

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sum == 0) {
                    ToastUtils.show(ProductDetailActivity.this, "购买数量不能为0");
                } else {
                    if (sum > maxSum) {
                        ToastUtils.show(ProductDetailActivity.this, "限购" + maxSum + "份");
                        return;
                    }
                    Intent intent = new Intent(ProductDetailActivity.this, OrderconfirmActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("productDetail", mProductDetail);
                    bundle.putString("num", sum+"");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                popupWindow.dismiss();
            }
        });
        if (popupWindow == null) {
            popupWindow = new PopupWindow(this);
            popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
//            popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
            popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
        }

        popupWindow.setContentView(view);
        popupWindow.showAtLocation(paybutton, Gravity.BOTTOM, 0, 0);
        popupWindow.update();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_deloge_share_haoyou:
                int mTargetScene = SendMessageToWX.Req.WXSceneSession;
//                int mTargetScene = SendMessageToWX.Req.WXSceneTimeline;
                shareWX(mTargetScene);
                mpopupWindow.dismiss();

                break;
            case R.id.img_deloge_share_pengyou:
                int mTargetScene1 = SendMessageToWX.Req.WXSceneTimeline;
                shareWX(mTargetScene1);
                mpopupWindow.dismiss();
                break;
            case R.id.layout_deloge_share_back:
                mpopupWindow.dismiss();

                break;
            default:
        }
    }

    private ProductDetailPresenter mProductDetailPresenter = new ProductDetailPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        //web.loadData(getHtmlData(html), "text/html; charset=UTF-8", null);
//        /////////获取数据
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
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
            mProductDetail = data;
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
            if(data.getData().getProductQuota()==-1){
                maxSum=Integer.MAX_VALUE;

            }else{
                maxSum = data.getData().getProductQuota();
            }

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

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}
