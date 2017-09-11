package com.coldraincn.laimihui.fragment;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.adapter.NineGridTestAdapter;
import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.entity.NineGridTestModel;
import com.coldraincn.laimihui.presenter.FirstPresenter;
import com.coldraincn.laimihui.presenter.SecondPresenter;
import com.coldraincn.laimihui.view.SecondView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavtwoFragment extends Fragment {

    private Toolbar toolbar;

    private ListView mListView;
    private NineGridTestAdapter mAdapter;
    // private List<NineGridTestModel> mList;
    private SecondPresenter mSecondPresenter = new SecondPresenter(getActivity());

    private List<NineGridTestModel> mList = new ArrayList<>();
    private String[] mUrls = new String[]{"http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png",
            "http://dev.wecity.co/upload/20170724/20794312545572058.png"};

    public NavtwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navtwo, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mListView = (ListView) view.findViewById(R.id.lv_bbs);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("来米汇");

        setHasOptionsMenu(true);
        mSecondPresenter.onCreate();
        mSecondPresenter.attachView(mSecondView);

        mSecondPresenter.getlistMessage("ee32f949083849c099d791a981f14d2d","16320885275460");
        initListData();
        initView();
    }


    private void initView() {


        mAdapter = new NineGridTestAdapter(getActivity());
        mAdapter.setList(mList);
        mListView.setAdapter(mAdapter);
    }
    private SecondView mSecondView = new SecondView() {

        @Override
        public void onSuccess(ListMessage data) {

        }

        @Override
        public void onError(String result) {

        }
    };

        private void initListData() {
        NineGridTestModel model1 = new NineGridTestModel();
        model1.urlList.add(mUrls[0]);
        mList.add(model1);

        NineGridTestModel model2 = new NineGridTestModel();
        model2.urlList.add(mUrls[4]);
        mList.add(model2);
//
//        NineGridTestModel model3 = new NineGridTestModel();
//        model3.urlList.add(mUrls[2]);
//        mList.add(model3);

        NineGridTestModel model4 = new NineGridTestModel();
        for (int i = 0; i < mUrls.length; i++) {
            model4.urlList.add(mUrls[i]);
        }
        model4.isShowAll = false;
        mList.add(model4);

        NineGridTestModel model5 = new NineGridTestModel();
        for (int i = 0; i < mUrls.length; i++) {
            model5.urlList.add(mUrls[i]);
        }
        model5.isShowAll = true;//显示全部图片
        mList.add(model5);

        NineGridTestModel model6 = new NineGridTestModel();
        for (int i = 0; i < 9; i++) {
            model6.urlList.add(mUrls[i]);
        }
        mList.add(model6);

        NineGridTestModel model7 = new NineGridTestModel();
        for (int i = 3; i < 7; i++) {
            model7.urlList.add(mUrls[i]);
        }
        mList.add(model7);

        NineGridTestModel model8 = new NineGridTestModel();
        for (int i = 3; i < 6; i++) {
            model8.urlList.add(mUrls[i]);
        }
        mList.add(model8);
    }



}
