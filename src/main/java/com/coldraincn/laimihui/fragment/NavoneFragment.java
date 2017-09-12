package com.coldraincn.laimihui.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.adapter.FirstFiveAdapter;
import com.coldraincn.laimihui.adapter.FirstFourAdapter;
import com.coldraincn.laimihui.adapter.FirstOneAdapter;
import com.coldraincn.laimihui.adapter.FirstThreeAdapter;
import com.coldraincn.laimihui.adapter.FirstTwoAdapter;
import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.Product;
import com.coldraincn.laimihui.entity.SeasonSell;
import com.coldraincn.laimihui.entity.SelectTopic;
import com.coldraincn.laimihui.entity.TodayExplosion;
import com.coldraincn.laimihui.entity.VipProduct;
import com.coldraincn.laimihui.presenter.FirstPresenter;
import com.coldraincn.laimihui.view.FirstView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.GlideImageLoader;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavoneFragment extends Fragment {

    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    private RecyclerView mRecyclerView3;
    private RecyclerView mRecyclerView4;
    private RecyclerView mRecyclerView5;
    private FirstOneAdapter mFirstOneAdapter;
    private FirstTwoAdapter mFirstTwoAdapter;
    private FirstThreeAdapter mFirstThreeAdapterr;
    private FirstFourAdapter mFirstFourAdapter;
    private FirstFiveAdapter mFirstFiveAdapter;
    private List<Map<String, Object>> listItems1=null;
    private List<Map<String, Object>> listItems2=null;
    private List<Map<String, Object>> listItems3=null;
    private List<Map<String, Object>> listItems4=null;
    private List<Map<String, Object>> listItems5=null;

    private Banner banner;
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    private String token;

    private FirstPresenter mFirstPresenter = new FirstPresenter(getActivity());
    public NavoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_navone, container, false);
        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.rv1);
        mRecyclerView2 = (RecyclerView) view.findViewById(R.id.rv2);
        mRecyclerView3 = (RecyclerView) view.findViewById(R.id.rv3);
        mRecyclerView4 = (RecyclerView) view.findViewById(R.id.rv4);
        mRecyclerView5 = (RecyclerView) view.findViewById(R.id.rv5);


        banner = (Banner) view.findViewById(R.id.banner);
        return view;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences settings = getActivity().getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "");

        mFirstPresenter.onCreate();
        mFirstPresenter.attachView(mFirstView);

        mFirstPresenter.getTodayExplosionList(token);
        mFirstPresenter.getActivityList(token);
        mFirstPresenter.getExcellentFreshOnLineList(token);
        mFirstPresenter.getSeasonSellList(token);
        mFirstPresenter.getVipProductList(token);
        mFirstPresenter.getSelectTopicList(token);
//
//        mFirstPresenter.getTodayExplosionList("f74c0b1ac19c482e8a2364cf80e98296");
//        mFirstPresenter.getActivityList("f74c0b1ac19c482e8a2364cf80e98296");
//        mFirstPresenter.getExcellentFreshOnLineList("f74c0b1ac19c482e8a2364cf80e98296");
//        mFirstPresenter.getSeasonSellList("f74c0b1ac19c482e8a2364cf80e98296");
//        mFirstPresenter.getVipProductList("f74c0b1ac19c482e8a2364cf80e98296");
//        mFirstPresenter.getSelectTopicList("f74c0b1ac19c482e8a2364cf80e98296");

    }
    private FirstView mFirstView = new FirstView() {



        @Override
        public void onError(String result) {
            Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoadActivityList(List images) {

            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(images);
            banner.setBannerAnimation(Transformer.DepthPage);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(5000);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.CENTER);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }
        @Override
        public void onSuccess1(TodayExplosion mLactivity) {
            listItems1=getListItems1(mLactivity);
            mFirstOneAdapter=new FirstOneAdapter(getActivity(),listItems1);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView1.setHasFixedSize(true);
            mRecyclerView1.setAdapter(mFirstOneAdapter);
        }

        @Override
        public void onSuccess2(FreshOnLine mLactivity) {
            listItems2=getListItems2(mLactivity);
            mFirstTwoAdapter=new FirstTwoAdapter(getActivity(),listItems2);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView2.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView2.setHasFixedSize(true);
            mRecyclerView2.setAdapter(mFirstTwoAdapter);
        }

        @Override
        public void onSuccess3(SeasonSell mLactivity) {

            listItems3=getListItems3(mLactivity);
            mFirstThreeAdapterr=new FirstThreeAdapter(getActivity(),listItems3);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView3.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView3.setHasFixedSize(true);
            mRecyclerView3.setAdapter(mFirstThreeAdapterr);
        }

        @Override
        public void onSuccess4(VipProduct mLactivity) {

            listItems4=getListItems4(mLactivity);
            mFirstFourAdapter=new FirstFourAdapter(getActivity(),listItems4);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView4.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView4.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView4.setHasFixedSize(true);
            mRecyclerView4.setAdapter(mFirstFourAdapter);
        }

        @Override
        public void onSuccess5(SelectTopic mLactivity) {
            listItems5=getListItems5(mLactivity);
            mFirstFiveAdapter=new FirstFiveAdapter(getActivity(),listItems5);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView5.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView5.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView5.setHasFixedSize(true);
            mRecyclerView5.setAdapter(mFirstFiveAdapter);
        }

        @Override
        public void onSuccess6(Product mLactivity) {

        }
    };
    protected List<Map<String, Object>> getListItems1(TodayExplosion stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().get(i).getImg());
            map.put("url", stList.getData().get(i).getUrl());
            map.put("urlstatus", stList.getData().get(i).getUrlstatus());

            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems2(FreshOnLine stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().get(i).getImg());
            map.put("url", stList.getData().get(i).getUrl());
            map.put("urlstatus", stList.getData().get(i).getUrlstatus());

            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems3(SeasonSell stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().get(i).getImg());
            map.put("url", stList.getData().get(i).getUrl());
            map.put("urlstatus", stList.getData().get(i).getUrlstatus());
            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems4(VipProduct stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().get(i).getImg());
            map.put("url", stList.getData().get(i).getUrl());
            map.put("urlstatus", stList.getData().get(i).getUrlstatus());
            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems5(SelectTopic stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().get(i).getImg());
            map.put("url", stList.getData().get(i).getUrl());
            map.put("urlstatus", stList.getData().get(i).getUrlstatus());

            listItems.add(map);
        }

        return listItems;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mFirstPresenter.onStop();
    }


}
