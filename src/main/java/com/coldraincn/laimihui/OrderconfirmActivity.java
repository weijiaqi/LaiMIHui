package com.coldraincn.laimihui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.coldraincn.laimihui.Alipay.AliSetting;
import com.coldraincn.laimihui.Alipay.PayResult;
import com.coldraincn.laimihui.Alipay.SignUtils;
import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.BindPhone;
import com.coldraincn.laimihui.entity.MessageCode;
import com.coldraincn.laimihui.entity.ProductDetail;
import com.coldraincn.laimihui.entity.createOrder;
import com.coldraincn.laimihui.presenter.BindcellPresenter;
import com.coldraincn.laimihui.presenter.OrderconfirmPresenter;
import com.coldraincn.laimihui.view.BindcellView;
import com.coldraincn.laimihui.view.OrderconfirmView;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OrderconfirmActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";

    private String token;
    private String productOid;
    private String addressOid="000";
    private String communityOid;
    private String tradeCount;
    private String spbillCreateIp;
    private String freight="0";
    private String orderRemark;


    private static final int SDK_PAY_FLAG = 1;
    private String sumprice;
    private int flag = 0;
    private ProductDetail mProductDetail;
    private String num;

    @BindView(R.id.tv_info_text)
    TextView tvInfoText;
    @BindView(R.id.tv_collect_nike)
    TextView tvCollectNike;
    @BindView(R.id.tv_collect_address)
    TextView tvCollectAddress;
    @BindView(R.id.getmessage)
    RelativeLayout getmessage;
    @BindView(R.id.tv_order_text)
    TextView tvOrderText;
    @BindView(R.id.iv_product_image)
    ImageView ivProductImage;
    @BindView(R.id.productname)
    TextView productname;
    @BindView(R.id.productprice)
    TextView productprice;
    @BindView(R.id.productnum)
    TextView productnum;
    @BindView(R.id.beizhu)
    EditText beizhu;
    @BindView(R.id.youhui)
    TextView youhui;
    @BindView(R.id.getyouhui)
    LinearLayout getyouhui;
    @BindView(R.id.checkboxmoney)
    CheckBox checkboxmoney;
    @BindView(R.id.shangpinjie)
    TextView shangpinjie;
    @BindView(R.id.youhuijie)
    TextView youhuijie;
    @BindView(R.id.yunfei)
    TextView yunfei;
    @BindView(R.id.zongjine)
    TextView zongjine;
    @BindView(R.id.yingfu)
    TextView yingfu;
    @BindView(R.id.pay)
    Button pay;

    @OnClick(R.id.pay)
    public void makeorder(){
        if(TextUtils.isEmpty(beizhu.getText())){
            Toast.makeText(OrderconfirmActivity.this, "请填写备注！", Toast.LENGTH_LONG).show();
        }else{
            orderRemark=beizhu.getText().toString();
            mOrderconfirmPresenter.createOrder(token,
                    productOid,
                    addressOid,
                    communityOid,
                    tradeCount,
                    spbillCreateIp,
                    freight,
                    orderRemark);
        }


    }




    private OrderconfirmPresenter mOrderconfirmPresenter = new OrderconfirmPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderconfirm);
        ButterKnife.bind(this);

        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        communityOid=settings.getString(PREF_CID,"1");

        Bundle bundle = this.getIntent().getExtras();
        mProductDetail = (ProductDetail) bundle.getSerializable("productDetail");
        tradeCount = (String) bundle.getString("num");

        productnum.setText("数量："+tradeCount+"个");
        productprice.setText(String.valueOf(mProductDetail.getData().getShowSalePrice())+"元");
        productname.setText(mProductDetail.getData().getProductName());
        Picasso.with(OrderconfirmActivity.this).load(mProductDetail.getData().getCoverId()).into(ivProductImage);
        yingfu.setText(String.valueOf(mProductDetail.getData().getShowSalePrice())+"元");
        productOid=String.valueOf(mProductDetail.getData().getObjectId());

        mOrderconfirmPresenter.onCreate();
        mOrderconfirmPresenter.attachView(mOrderconfirmView);
        mOrderconfirmPresenter.getDefaltAddress(token);

        spbillCreateIp=getIPAddress(this);

    }

    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }
    private OrderconfirmView mOrderconfirmView = new OrderconfirmView() {

        @Override
        public void onAddress(Address result) {
            addressOid=String.valueOf(result.getData().getObjectId());
            tvCollectAddress.setText("收货地址："+result.getData().getReceiverAddress());
        }

        @Override
        public void onError(String result) {

        }

        @Override
        public void onCreateOrder(createOrder result) {
            Intent intent = new Intent(OrderconfirmActivity.this, PayActivity.class);
            Bundle bundle = new Bundle();

            bundle.putSerializable("createOrder", result);

            intent.putExtras(bundle);
            OrderconfirmActivity.this.startActivity(intent);
            finish();
           // bundle.putSerializable("hotelData", resultListData.get(getLayoutPosition()));
           // Toast.makeText(OrderconfirmActivity.this, result.getData().getPrepayId(), Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public void onDestroy(){
        super.onDestroy();
        mOrderconfirmPresenter.onStop();
    }
}
