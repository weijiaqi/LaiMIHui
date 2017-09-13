package com.coldraincn.laimihui.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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
import com.coldraincn.laimihui.adapter.HomeProductAdapter;
import com.coldraincn.laimihui.entity.FreshOnLine;
import com.coldraincn.laimihui.entity.HomeHoteData;
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
import common.RecycleViewUtil;
import common.SpaceItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavoneFragment extends Fragment {

    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;
    private RecyclerView mRecyclerView3;
    private RecyclerView mRecyclerView4;
    private RecyclerView mRecyclerView5;
    private RecyclerView mProductRecycleView;
    private FirstOneAdapter mFirstOneAdapter;
    private FirstTwoAdapter mFirstTwoAdapter;
    private FirstThreeAdapter mFirstThreeAdapterr;
    private FirstFourAdapter mFirstFourAdapter;
    private FirstFiveAdapter mFirstFiveAdapter;
    private HomeProductAdapter homeProductAdapter;
    private List<Map<String, Object>> listItems1=null;
    private List<Map<String, Object>> listItems2=null;
    private List<Map<String, Object>> listItems3=null;
    private List<Map<String, Object>> listItems4=null;
    private List<Map<String, Object>> listItems5=null;
    private List<Map<String, Object>> listProduct=null;

    RecycleViewUtil recycleViewUtil;

    private Banner banner;
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    private String token;

    private FirstPresenter mFirstPresenter = new FirstPresenter(getActivity());
    private int pageNo = 1;
    private int pageSize = 2;
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
        mProductRecycleView = (RecyclerView) view.findViewById(R.id.rv_product_list);


        banner = (Banner) view.findViewById(R.id.banner);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences settings = getActivity().getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");

        mFirstPresenter.onCreate();
        mFirstPresenter.attachView(mFirstView);

       // mFirstPresenter.getActivityList(token);
        mFirstPresenter.getHomeHoteList(token);

        mFirstPresenter.getProductList(token,pageNo + "",pageSize + "");;
//


    }
    private FirstView mFirstView = new FirstView() {



        @Override
        public void onError(String result) {
            Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoadActivityList(List images) {

//            //设置图片加载器
//            banner.setImageLoader(new GlideImageLoader());
//            //设置图片集合
//            banner.setImages(images);
//            banner.setBannerAnimation(Transformer.DepthPage);
//            //设置自动轮播，默认为true
//            banner.isAutoPlay(true);
//            //设置轮播时间
//            banner.setDelayTime(5000);
//            //设置指示器位置（当banner模式中有指示器时）
//            banner.setIndicatorGravity(BannerConfig.CENTER);
//            //banner设置方法全部调用完毕时最后调用
//            banner.start();
        }

        @Override
        public void onSuccess6(Product mLactivity) {
            pageNo++;
//            mProduct.addAll(mLactivity.getData().getDatalist());
            listProduct = getListProduct(mLactivity);
            homeProductAdapter = new HomeProductAdapter(getActivity(),listProduct);
            mProductRecycleView.setLayoutManager(new GridLayoutManager(getActivity(),2));
            mProductRecycleView.setItemAnimator(new DefaultItemAnimator());
            mProductRecycleView.setHasFixedSize(true);
            if (!hasAdded) {
                mProductRecycleView.addItemDecoration(new SpaceItemDecoration(20));
                hasAdded = true;
            }
            recycleViewUtil = new RecycleViewUtil(new RecycleViewUtil.RecycleCallBack() {
                @Override
                public void doRefresh() {

                }

                @Override
                public void doLoadMore() {
                    mFirstPresenter.getProductList(token,pageNo + "",pageSize + "");
                }
            },mProductRecycleView,homeProductAdapter,true);
            recycleViewUtil.onLoadComplete(mLactivity.getData().getDatalist().size() < pageSize);
            homeProductAdapter.notifyDataSetChanged();
        }

        @Override
        public void onSuccess7(HomeHoteData mLactivity) {
            listItems1 = getListItems1(mLactivity);
            listItems2 = getListItems2(mLactivity);
            listItems3 = getListItems3(mLactivity);
            listItems4 = getListItems4(mLactivity);
            listItems5 = getListItems5(mLactivity);

            mFirstOneAdapter=new FirstOneAdapter(getActivity(),listItems1);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView1.setHasFixedSize(true);
            mRecyclerView1.setAdapter(mFirstOneAdapter);

            mFirstTwoAdapter=new FirstTwoAdapter(getActivity(),listItems2);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView2.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView2.setHasFixedSize(true);
            mRecyclerView2.setAdapter(mFirstTwoAdapter);

            mFirstThreeAdapterr=new FirstThreeAdapter(getActivity(),listItems3);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView3.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView3.setHasFixedSize(true);
            mRecyclerView3.setAdapter(mFirstThreeAdapterr);

            mFirstFourAdapter=new FirstFourAdapter(getActivity(),listItems4);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView4.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView4.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView4.setHasFixedSize(true);
            mRecyclerView4.setAdapter(mFirstFourAdapter);

            mFirstFiveAdapter=new FirstFiveAdapter(getActivity(),listItems5);
            // mLayoutManager = new LinearLayoutManager(HotellistActivity.this);
            mRecyclerView5.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView5.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView5.setHasFixedSize(true);
            mRecyclerView5.setAdapter(mFirstFiveAdapter);
        }
    };

    private boolean hasAdded = false;

    protected List<Map<String, Object>> getListItems1(HomeHoteData stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().getTodayExplosionList().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().getTodayExplosionList().get(i).getImg());
            map.put("url", stList.getData().getTodayExplosionList().get(i).getUrl());
            map.put("urlstatus", stList.getData().getTodayExplosionList().get(i).getUrlstatus());

            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems2(HomeHoteData stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().getExcellentFreshOnLineList().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().getExcellentFreshOnLineList().get(i).getImg());
            map.put("url", stList.getData().getExcellentFreshOnLineList().get(i).getUrl());
            map.put("urlstatus", stList.getData().getExcellentFreshOnLineList().get(i).getUrlstatus());

            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems3(HomeHoteData stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().getSeasonSellList().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().getSeasonSellList().get(i).getImg());
            map.put("url", stList.getData().getSeasonSellList().get(i).getUrl());
            map.put("urlstatus", stList.getData().getSeasonSellList().get(i).getUrlstatus());
            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems4(HomeHoteData stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().getVipProductList().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().getVipProductList().get(i).getImg());
            map.put("url", stList.getData().getVipProductList().get(i).getUrl());
            map.put("urlstatus", stList.getData().getVipProductList().get(i).getUrlstatus());
            listItems.add(map);
        }

        return listItems;
    }
    protected List<Map<String, Object>> getListItems5(HomeHoteData stList) {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stList.getData().getSelectTopicList().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("img", stList.getData().getSelectTopicList().get(i).getImg());
            map.put("url", stList.getData().getSelectTopicList().get(i).getUrl());
            map.put("urlstatus", stList.getData().getSelectTopicList().get(i).getUrlstatus());

            listItems.add(map);
        }

        return listItems;
    }

    List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
    protected List<Map<String, Object>> getListProduct(Product mLactivity) {

        for (int i = 0; i < mLactivity.getData().getDatalist().size(); i++) {



            Map<String, Object> map = new HashMap<String, Object>();

            map.put("pic", mLactivity.getData().getDatalist().get(i).getCoverId());
            map.put("name", mLactivity.getData().getDatalist().get(i).getProductName());
            map.put("price", mLactivity.getData().getDatalist().get(i).getShowSalePrice());

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
