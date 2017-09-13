package com.coldraincn.laimihui.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.adapter.NineGridTestAdapter;
import com.coldraincn.laimihui.entity.ListMessage;
import com.coldraincn.laimihui.presenter.SecondPresenter;
import com.coldraincn.laimihui.view.SecondView;

import java.util.ArrayList;
import java.util.List;

import common.LogUtil;
import common.ToastUtils;

import static com.coldraincn.laimihui.OrderconfirmActivity.PREFUSER;
import static com.coldraincn.laimihui.OrderconfirmActivity.PREF_CID;
import static com.coldraincn.laimihui.OrderconfirmActivity.PREF_TOKEN;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavtwoFragment extends Fragment {
    private static final String TAG = "NavtwoFragment";
    private Toolbar toolbar;

    private ListView mListView;
    private NineGridTestAdapter mAdapter;
    // private List<NineGridTestModel> mList;
    private SecondPresenter mSecondPresenter = new SecondPresenter(getActivity());

    private List<ListMessage.DataBean.DatalistBean> mList = new ArrayList<>();

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
        SharedPreferences settings = getActivity().getSharedPreferences(PREFUSER, 0);
        String token = settings.getString(PREF_TOKEN, "1");
        String cid = settings.getString(PREF_CID, "1");

        mSecondPresenter.getlistMessage(token, cid);


    }


    private SecondView mSecondView = new SecondView() {

        @Override
        public void onSuccess(ListMessage data) {
            LogUtil.d(TAG, "data.getStatus():" + data.getStatus());

            mList = data.getData().getDatalist();
            mAdapter = new NineGridTestAdapter(getActivity());
            mAdapter.setList(mList);
            mListView.setAdapter(mAdapter);
        }

        @Override
        public void onError(String result) {
            LogUtil.e(TAG, result);
            ToastUtils.show(getActivity(), result);
        }
    };

    @Override
    public void onDestroy(){
        super.onDestroy();
        mSecondPresenter.onStop();
    }

}
