package com.coldraincn.laimihui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.coldraincn.laimihui.fragment.OrdersFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyOrdersActivity extends AppCompatActivity
{
    @BindView(R.id.my_orders_tab)
    TabLayout tabLayout;
    @BindView(R.id.my_orders_viewpager)
    ViewPager viewpager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView titleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_orders);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.arrow);

        getSupportActionBar().setTitle("");

        titleView.setText("我的订单");

        viewpager.setOffscreenPageLimit(2);

        viewpager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (android.R.id.home == item.getItemId())
        {
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class PagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> pageList = new ArrayList<>(4);

        private final List<String> titleList = new ArrayList<>(4);

        public PagerAdapter(FragmentManager fm)
        {
            super(fm);

            pageList.add(OrdersFragment.newInstance(null));

            titleList.add("全部订单");

            pageList.add(OrdersFragment.newInstance("1"));

            titleList.add("待付款");

            pageList.add(OrdersFragment.newInstance("2"));

            titleList.add("待发货");

            pageList.add(OrdersFragment.newInstance("3"));

            titleList.add("待收货");
        }

        @Override
        public Fragment getItem(int position)
        {
            return pageList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return titleList.get(position);
        }

        @Override
        public int getCount()
        {
            return pageList.size();
        }
    }
}
