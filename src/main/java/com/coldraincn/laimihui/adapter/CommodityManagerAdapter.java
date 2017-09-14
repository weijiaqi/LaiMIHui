package com.coldraincn.laimihui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.GuangGaoActivity;
import com.coldraincn.laimihui.HaiBaoActivity;
import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.StartActivity;
import com.coldraincn.laimihui.entity.ShangPin;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/09/12.
 * 商品管理
 */

public class CommodityManagerAdapter extends RecyclerView.Adapter<CommodityManagerAdapter.MyViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    int status = 0;
//    private List<CommocityManager.DataBean> data;
    private  List<ShangPin> list;
    public CommodityManagerAdapter(Context context, List<ShangPin> list
    ) {
        mContext = context;

        mLayoutInflater = LayoutInflater.from(context);
        this.list = list;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(
                mLayoutInflater.inflate(R.layout.item_commodity, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//
                .cacheOnDisk(true)//
                .bitmapConfig(Bitmap.Config.RGB_565)//
                .build();
        final ShangPin shangPin=list.get(position);
        ImageLoader.getInstance().displayImage(shangPin.getPicture(),
                holder.tupian, options);
        holder.name.setText(shangPin.getName());
        holder.price.setText("售价:"+shangPin.getPrice());
        holder.xiajia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.xiajia.setBackgroundResource(R.color.red);

                switch (status) {
                    case  0: //下架
                        String url = "http://api.17yun.com.cn/community/onLineCommunityProduct.do";

                        OkHttpClient mOkHttpClient = new OkHttpClient();
                        RequestBody formBody = new FormBody.Builder()
                                .add("communityOid", "1")
                                .add("productOid","533671615716821")
                                .build();
                        Request request = new Request.Builder()
                                .addHeader("token", "9e5292a94082476ebd6cbd4f55916885")
                                .url(url)
                                .post(formBody)
                                .build();
                        Call call = mOkHttpClient.newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {

                                new Thread(){
                                    @Override
                                    public void run() {
                                        super.run();
                                        Toast.makeText(mContext,"你点击了下架",Toast.LENGTH_LONG).show();
                                        holder.xiajia.setText("上架");
                                        holder.xiajia.setBackgroundResource(R.color.red);
                                        status = 1;
                                    }
                                };

                            }
                        });
                        break;
                    case 1: //上架
                        String url2 = "http://api.17yun.com.cn/community/offLineCommunityProduct.do";

                        OkHttpClient mOkHttpClient2 = new OkHttpClient();
                        RequestBody formBody2 = new FormBody.Builder()
                                .add("communityOid", "1")  //社区店主键id
                                .add("productOid","533671615716821") //商品主键id
                                .build();
                        Request request2 = new Request.Builder()
                                .addHeader("token", "9e5292a94082476ebd6cbd4f55916885")
                                .url(url2)
                                .post(formBody2)
                                .build();
                        Call call2 = mOkHttpClient2.newCall(request2);
                        call2.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                holder.xiajia.setText("下架");
                                holder.xiajia.setBackgroundResource(R.color.green);
                                status = 0;
                            }
                        });
                        break;
                    default:
                        break;
                }
            }
        });

        holder.haibaotiao.setOnClickListener(new View.OnClickListener() {    //生成海报

            @Override
            public void onClick(View view) {
                String url = "http://api.17yun.com.cn/community/postimg.do";

                OkHttpClient mOkHttpClient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("communityOid", "8125665711450378")  //社区店主键id
                        .add("objectId","533671615716821") //商品主键id
                        .build();
                Request request = new Request.Builder()
                        .addHeader("token", "1")
                        .url(url)
                        .post(formBody)
                        .build();
                Call call = mOkHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str=response.body().string();
//                        {"status":"OK","data":"http://api.17yun.com.cn:80/upload//2017/9/14/pi8125665711450378-247058893786642.jpg"}


                        try {
                            JSONObject object = new JSONObject(str);
                            String status = object.getString("data");
                            Intent in=new Intent(mContext,HaiBaoActivity.class);
                            in.putExtra("haibao",status);
                            mContext.startActivity(in);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
        holder.guanggao.setOnClickListener(new View.OnClickListener() {   //生成广告
            @Override
            public void onClick(View view) {

                String url = "http://api.17yun.com.cn/community/advertImg.do";

                OkHttpClient mOkHttpClient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("communityOid", "8125665711450378")  //社区店主键id
                        .add("objectId","533671615716821") //商品主键id
                        .build();
                Request request = new Request.Builder()
                        .addHeader("token", "1")
                        .url(url)
                        .post(formBody)
                        .build();
                Call call = mOkHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str=response.body().string();
                        try {
                            JSONObject object = new JSONObject(str);
                            String status2 = object.getString("data");
                            Intent in=new Intent(mContext,GuangGaoActivity.class);
                            in.putExtra("guanggaotwo",status2);
                            mContext.startActivity(in);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView tupian; //图片
        TextView  name;//名称
        TextView  price; //价格
        TextView  shouyijin; //收益金
        TextView dianjinumber; //点击次数
        Button  xiajia;
        Button  haibaotiao;
        Button  guanggao;
        public MyViewHolder(View itemView) {
            super(itemView);
            tupian=itemView.findViewById(R.id.tupian);
            name=itemView.findViewById(R.id.shangpinname);
            price=itemView.findViewById(R.id.price);
            shouyijin=itemView.findViewById(R.id.shouyijin);
            xiajia=itemView.findViewById(R.id.xiajia);
            haibaotiao=itemView.findViewById(R.id.haibao);
            guanggao=itemView.findViewById(R.id.guanggaotiao);
        }
    }
}
