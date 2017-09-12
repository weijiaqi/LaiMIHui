package com.coldraincn.laimihui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.Alipay.AliSetting;
import com.coldraincn.laimihui.entity.createOrder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import common.Constants;
import io.github.mayubao.pay_library.AliPayAPI;
import io.github.mayubao.pay_library.AliPayReq;
import io.github.mayubao.pay_library.PayAPI;
import io.github.mayubao.pay_library.WechatPayReq;

public class PayActivity extends AppCompatActivity {
    private String mypaytype="1";
    private createOrder mOrder;

    private String newPrice;
    private String payNotifyUrl;

    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;

    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.getmessage)
    RelativeLayout getmessage;
    @BindView(R.id.weixinpay)
    RadioButton weixinpay;
    @BindView(R.id.alipay)
    RadioButton alipay;
    @BindView(R.id.paytype)
    RadioGroup paytype;
    @BindView(R.id.button6)
    Button button6;

    @OnClick(R.id.button6)
    public void order() {
        switch (mypaytype){
            case "1":
               // 1.创建微信支付请求
                        WechatPayReq wechatPayReq = new WechatPayReq.Builder()
                                .with(PayActivity.this) //activity实例
                                .setAppId("wx3bb6d108dec83903") //微信支付AppID
                                .setPartnerId("1488333992")//微信支付商户号
                                .setPrepayId("wx2017091217382532dc86632a0653961178")//预支付码
								.setPackageValue("Sign=WXPay")//"Sign=WXPay"
                                .setNonceStr("d63fbf8c3173730f82b150c5ef38b8ff")
                                .setTimeStamp("1505209501034")//时间戳
                                .setSign("768629B0438A0A575C4C22E5F292E0DB")//签名
                                .create();
                        //2.发送微信支付请求
                        PayAPI.getInstance().sendPayRequest(wechatPayReq);
                //关于微信支付的回调
                wechatPayReq.setOnWechatPayListener(weixnres);
                break;
            case "2":
                //1.创建支付宝支付配置
                        AliPayAPI.Config config = new AliPayAPI.Config.Builder()
                                .setRsaPrivate(AliSetting.RSA_PRIVATE) //设置私钥 (商户私钥，pkcs8格式)
                                .setRsaPublic(AliSetting.RSA_PUBLIC)//设置公钥(// 支付宝公钥)
                                .setPartner(AliSetting.PARTNER) //设置商户
                                .setSeller(AliSetting.SELLER) //设置商户收款账号
                                .create();

                        //2.创建支付宝支付请求
                        AliPayReq aliPayReq = new AliPayReq.Builder()
                                .with(PayActivity.this)//Activity实例
                                .apply(config)//支付宝支付通用配置
                                .setOutTradeNo(getOutTradeNo())//设置唯一订单号
                                .setPrice(newPrice)//设置订单价格
                                .setSubject("来米汇")//设置订单标题
                                .setBody("来米汇订单支付")//设置订单内容 订单详情
                                .setCallbackUrl(payNotifyUrl)//设置回调地址
                                .create()//
                                .setOnAliPayListener(null);//

                        //3.发送支付宝支付请求
                        PayAPI.getInstance().sendPayRequest(aliPayReq);

                        //关于支付宝支付的回调
                       aliPayReq.setOnAliPayListener(alires);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        Bundle bundle = this.getIntent().getExtras();
        mOrder = (createOrder) bundle.getSerializable("createOrder");
        textView8.setText(mOrder.getData().getOrderNo());
        textView10.setText(mOrder.getData().getMoney());
        payNotifyUrl=mOrder.getData().getPayNotifyUrl();

        String price = mOrder.getData().getMoney();
        double priceValue = Double.parseDouble(price);
        int cents = (int)(priceValue * 100);
        newPrice = Integer.toString(cents);

        paytype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String msg = "";
                if(weixinpay.getId()==checkedId){
                    mypaytype = "1";
                }
                if(alipay.getId()==checkedId){
                    mypaytype = "2";
                }

            }
        });
    }
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }
    private AliPayReq.OnAliPayListener alires= new AliPayReq.OnAliPayListener(){

        @Override
        public void onPaySuccess(String resultInfo) {
            Intent intent = new Intent (PayActivity.this,PaySuccessActivity.class);
            startActivity(intent);
            PayActivity.this.finish();


        }

        @Override
        public void onPayFailure(String resultInfo) {
            Toast.makeText(PayActivity.this, "支付失败", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPayConfirmimg(String resultInfo) {

        }

        @Override
        public void onPayCheck(String status) {

        }
    };
    private WechatPayReq.OnWechatPayListener weixnres=new WechatPayReq.OnWechatPayListener(){

        @Override
        public void onPaySuccess(int errorCode) {
            Log.d("weixin ",String.valueOf(errorCode));
        }

        @Override
        public void onPayFailure(int errorCode) {
            Log.d("weixin ",String.valueOf(errorCode));

        }
    };

}
