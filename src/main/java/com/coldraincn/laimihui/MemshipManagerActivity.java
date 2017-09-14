package com.coldraincn.laimihui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.adapter.MemshipManagerAdapter;
import com.coldraincn.laimihui.entity.Memship;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/09/13.
 * 会员店管理
 */

public class MemshipManagerActivity extends AppCompatActivity {
    @BindView(R.id.member_manager)
    RecyclerView memberManager;
    @BindView(R.id.search_content)
    EditText searchContent;//搜索框内容
    @BindView(R.id.search)  //查找按钮
    Button search;
    @BindView(R.id.title_name)
    TextView titleName;  //标题
    @BindView(R.id.save)
    TextView save;
    private MemshipManagerAdapter memshipManagerAdapter;
    private List<Memship.DataBean> data;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    String str = (String) msg.obj;
                    Memship memship=new Gson().fromJson(str,Memship.class);


                        data = memship.getData();
                        memshipManagerAdapter = new MemshipManagerAdapter(MemshipManagerActivity.this, data);
                        memberManager.setAdapter(memshipManagerAdapter);
                        memshipManagerAdapter.notifyDataSetChanged();

                    break;



            }
        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);
        ButterKnife.bind(this);
        titleName.setText("店铺名称");
        init();
        indata();
    }



    public  void init(){
       final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       memberManager.setLayoutManager(layoutManager);

   }
    public  void indata(){
        String url = "http://api.17yun.com.cn/community/getCommunityListWithAgent.do";
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .addHeader("token", "4cd27a9172334ee9951c6900bfa06d2f")
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String str=e.toString();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String str=response.body().string();
                android.os.Message msg = android.os.Message.obtain();
                msg.obj = str;
                msg.what = 1;
                handler.sendMessage(msg);





            }
        });

    }

}
