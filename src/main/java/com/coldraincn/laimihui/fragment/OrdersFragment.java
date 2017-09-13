package com.coldraincn.laimihui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.adapter.OrdersAdapter;
import com.coldraincn.laimihui.entity.OrderList;
import com.coldraincn.laimihui.presenter.OrdersPresenter;
import com.coldraincn.laimihui.view.OrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class OrdersFragment extends Fragment
{
    public static final String PREFUSER = "USER";
    public static final String PREF_TOKEN = "TOKEN";

    @BindView(R.id.orders_recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    private String token;

    private String orderStatus;

    private OrdersPresenter mOrdersPresenter = new OrdersPresenter(getActivity());

    public static OrdersFragment newInstance(String orderStatus)
    {
        OrdersFragment fragment = new OrdersFragment();

        Bundle arguments = new Bundle();

        arguments.putString("orderStatus", orderStatus);

        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_orders, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        orderStatus = getArguments().getString("orderStatus");

        SharedPreferences settings = getActivity().getSharedPreferences(PREFUSER, 0);

        token = settings.getString(PREF_TOKEN, "1");

        mOrdersPresenter.onCreate();

        mOrdersPresenter.attachView(mOrdersView);

        mOrdersPresenter.getUserOrderList(token, orderStatus);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();

        mOrdersPresenter.attachView(null);

        unbinder.unbind();
    }

    private final OrdersView mOrdersView = new OrdersView()
    {
        @Override
        public void onSuccess(OrderList orderList)
        {
            recyclerView.setAdapter(new OrdersAdapter(getActivity(), orderList.getOrderItems()));
        }

        @Override
        public void onError(String result)
        {
            System.out.println(result);
        }
    };
}
