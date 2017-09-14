package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.coldraincn.laimihui.ProductDetailActivity;
import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.myview.NineGridTestLayout;
import com.coldraincn.laimihui.widget.MyListView;
import com.coldraincn.laimihui.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

import java.io.ByteArrayOutputStream;
import java.util.List;

import common.CommonUtils;
import common.ToastUtils;

import static com.coldraincn.laimihui.AppApplication.api;
import static com.coldraincn.laimihui.LoginActivity.PREF_CID;
import static com.coldraincn.laimihui.ProductDetailActivity.PREFUSER;

/**
 * Created by hd on 2017/9/8.
 */
public class NineGridTestAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    private List<ListMessage.DataBean.DatalistBean> mList;
    protected LayoutInflater inflater;
    ListMessage.DataBean.DatalistBean mBean;

    public NineGridTestAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<ListMessage.DataBean.DatalistBean> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return getListSize(mList);
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ListMessage.DataBean.DatalistBean bean = mList.get(position);
        ViewHolder holder = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = inflater.inflate(R.layout.item_bbs_nine_grid, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        holder.layout.setIsShowAll(mList.get(position).isShowAll);
        holder.layout.setUrlList(mList.get(position).getImglist());

        final List<ListMessage.DataBean.DatalistBean.ProductListBean> productList = bean.getProductList();
        MerchandiseAdapter merchandiseAdapter = new MerchandiseAdapter(mContext, productList);
        holder.listView.setAdapter(merchandiseAdapter);
        holder.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("productOid", productList.get(i).getSalePersent());
                mContext.startActivity(intent);
            }
        });
        holder.tv_title.setText(bean.getTitle());
        holder.tv_content.setText(bean.getContent());
        holder.tv_time.setText(bean.getCreatetimestrmess());
        holder.tv_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (productList != null && productList.size() >= 1) {
                    Intent intent = new Intent(mContext, ProductDetailActivity.class);
                    intent.putExtra("productOid", productList.get(0).getSalePersent());
                    mContext.startActivity(intent);
                } else {
                    ToastUtils.show(mContext, "产品列表为空");
                }

            }
        });
        final ViewHolder finalHolder = holder;
        holder.tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!CommonUtils.isWeixinAvilible(mContext)) {//没装微信
                    ToastUtils.show(mContext, "请先安装微信客户端");
                } else {
                    showPopMenu(finalHolder.tv_share);
                    mBean = bean;
                }

            }
        });
        return convertView;
    }

    private PopupWindow mpopupWindow;

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

    private class ViewHolder {
        NineGridTestLayout layout;
        MyListView listView;
        TextView tv_title;
        TextView tv_content;
        TextView tv_time;
        TextView tv_buy;
        TextView tv_share;

        public ViewHolder(View view) {
            layout = view.findViewById(R.id.layout_nine_grid);
            listView = view.findViewById(R.id.listView);
            tv_title = view.findViewById(R.id.tv_title);
            tv_content = view.findViewById(R.id.tv_content);
            tv_time = view.findViewById(R.id.tv_time);
            tv_buy = view.findViewById(R.id.tv_buy);
            tv_share = view.findViewById(R.id.tv_share);
        }
    }

    private static final int THUMB_SIZE = 150;

    private void shareWX(int mTargetScene) {
        WXEntryActivity.types = 2;
        WXWebpageObject webpage = new WXWebpageObject();
        SharedPreferences settings = mContext.getSharedPreferences(PREFUSER, 0);
        String communityOid = settings.getString(PREF_CID, "");
        webpage.webpageUrl = "http://dev.wecity.co/task/mall/dynamic/index.do?communityOid=" + mBean.getObjectId();
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = mBean.getTitle();
        msg.description ="最新爆款动态来了，点击查看并可下单购买。";
        Bitmap bmp = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = bmpToByteArray(thumbBmp, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = mTargetScene;
        api.sendReq(req);
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
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

    private int getListSize(List<ListMessage.DataBean.DatalistBean> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }


    private void showPopMenu(View v) {
        LinearLayout layout_share_back;
        ImageView img_share_haoyou, img_share_pengyou;
        View view = View.inflate(mContext, R.layout.deloge_share_wx, null);
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_in));
        LinearLayout ll_popup = (LinearLayout) view.findViewById(R.id.ll_share);

        ll_popup.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.push_bottom_in));

        img_share_haoyou = (ImageView) view.findViewById(R.id.img_deloge_share_haoyou);
        img_share_pengyou = (ImageView) view.findViewById(R.id.img_deloge_share_pengyou);

        layout_share_back = (LinearLayout) view.findViewById(R.id.layout_deloge_share_back);

        img_share_haoyou.setOnClickListener(this);
        img_share_pengyou.setOnClickListener(this);
        layout_share_back.setOnClickListener(this);


        if (mpopupWindow == null) {
            mpopupWindow = new PopupWindow(mContext);
            mpopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            mpopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            mpopupWindow.setBackgroundDrawable(new BitmapDrawable());

            mpopupWindow.setFocusable(true);
            mpopupWindow.setOutsideTouchable(true);
        }

        mpopupWindow.setContentView(view);
        mpopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        mpopupWindow.update();
    }
}
