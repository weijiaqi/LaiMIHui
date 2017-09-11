package com.coldraincn.laimihui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.coldraincn.laimihui.entity.NineGridTestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavthreeFragment extends Fragment {
    private Toolbar toolbar;
    private SearchView searchView;
    public NavthreeFragment() {
        // Required NavthreeFragment public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navthree, container, false);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("来米汇");

        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        // ((AppCompatActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_navtwofragment, menu);


        inflater.inflate(R.menu.menu_navtwofragment, menu);
        setSearchView(menu);
    }
    private void setSearchView(Menu menu) {
        MenuItem item = menu.getItem(0);
        SearchView searchView = (SearchView) item.getActionView();
        //设置展开后图标的样式,false时ICON在搜索框外,true为在搜索框内，无法修改
        // searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("搜索产品");
        searchView.setSubmitButtonEnabled(true);//设置最右侧的提交按钮

    }

}
