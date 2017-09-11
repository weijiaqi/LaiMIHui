package com.coldraincn.laimihui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderconfirmActivity extends AppCompatActivity {
    private static final int SDK_PAY_FLAG = 1;
    private String sumprice;
    private int flag = 0;

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
    public void orderpay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(OrderconfirmActivity.this);
        //builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("支付方式");
        final String[] pay = {"微信支付", "支付宝支付"};
        //    设置一个单项选择下拉框
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
         * 第三个参数给每一个单选项绑定一个监听器
         */
        builder.setSingleChoiceItems(pay, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        flag = 0;
                        //ToAliPay();
                        break;
                    case 1:
                        flag = 1;
                        break;
                }
                Toast.makeText(OrderconfirmActivity.this, "支付：" + pay[which], Toast.LENGTH_SHORT).show();

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (flag) {
                    case 0:
                        //1.创建微信支付请求
//                        WechatPayReq wechatPayReq = new WechatPayReq.Builder()
//                                .with(OrderconfirmActivity.this) //activity实例
//                                .setAppId(appid) //微信支付AppID
//                                .setPartnerId(partnerid)//微信支付商户号
//                                .setPrepayId(prepayid)//预支付码
////								.setPackageValue(wechatPayReq.get)//"Sign=WXPay"
//                                .setNonceStr(noncestr)
//                                .setTimeStamp(timestamp)//时间戳
//                                .setSign(sign)//签名
//                                .create();
//                        //2.发送微信支付请求
//                        PayAPI.getInstance().sendPayRequest(wechatPayReq);
                        break;
                    case 1:
//                        //1.创建支付宝支付配置
//                        AliPayAPI.Config config = new AliPayAPI.Config.Builder()
//                                .setRsaPrivate(AliSetting.RSA_PRIVATE) //设置私钥 (商户私钥，pkcs8格式)
//                                .setRsaPublic(AliSetting.RSA_PUBLIC)//设置公钥(// 支付宝公钥)
//                                .setPartner(AliSetting.PARTNER) //设置商户
//                                .setSeller(AliSetting.SELLER) //设置商户收款账号
//                                .create();
//
//                        //2.创建支付宝支付请求
//                        AliPayReq aliPayReq = new AliPayReq.Builder()
//                                .with(OrderconfirmActivity.this)//Activity实例
//                                .apply(config)//支付宝支付通用配置
//                                .setOutTradeNo(getOutTradeNo())//设置唯一订单号
//                                .setPrice("1")//设置订单价格
//                                .setSubject("来米汇")//设置订单标题
//                                .setBody("来米汇订单支付")//设置订单内容 订单详情
//                                .setCallbackUrl("http://notify.msp.hk/notify.htm")//设置回调地址
//                                .create()//
//                                .setOnAliPayListener(null);//
//
//                        //3.发送支付宝支付请求
//                        PayAPI.getInstance().sendPayRequest(aliPayReq);
//
//                        //关于支付宝支付的回调
//                       // aliPayReq.setOnAliPayListener(new AliPayReq.OnAliPayListener);
                        ToAliPay();
                        break;

                }

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // cancleorder("2", "2");
//                        Toast.makeText(HorderdetailActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(OrderconfirmActivity.this);
                        builder.setMessage("完成支付");
                        builder.setTitle("支付成功");
                        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // getOrderDetail();
                                dialog.dismiss();

                            }
                        });

                        builder.create().show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(OrderconfirmActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(OrderconfirmActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };

    private void ToAliPay() {
        if (TextUtils.isEmpty(AliSetting.PARTNER) || TextUtils.isEmpty(AliSetting.RSA_PRIVATE) || TextUtils.isEmpty(AliSetting.SELLER)) {
            new android.app.AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }
        //String orderInfo = getOrderInfo("阿拉旅行", "房间预订", horderData.getHroomorderPay()+horderData.getHroomorderDeposit());

        String orderInfo = getOrderInfo("来米汇", "订单支付", "1");

        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息
         */
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(OrderconfirmActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

    /**
     * get the sdk version. 获取SDK版本号
     */
    public void getSDKVersion() {
        PayTask payTask = new PayTask(this);
        String version = payTask.getVersion();
        Toast.makeText(this, version, Toast.LENGTH_SHORT).show();
    }

    /**
     * create the order info. 创建订单信息
     */
    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + AliSetting.PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + AliSetting.SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, AliSetting.RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderconfirm);
        ButterKnife.bind(this);
    }
}
