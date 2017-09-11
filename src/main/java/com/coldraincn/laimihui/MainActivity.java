package com.coldraincn.laimihui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coldraincn.laimihui.adapter.MainActivityViewPagerAdapter;
import com.coldraincn.laimihui.fragment.NavfourFragment;
import com.coldraincn.laimihui.fragment.NavoneFragment;
import com.coldraincn.laimihui.fragment.NavthreeFragment;
import com.coldraincn.laimihui.fragment.NavtwoFragment;

import common.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private Toolbar toolbar;
    private ImageView imageHead;
    private int mAppBarHeight;
    private AppBarLayout mAppBarLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageHead=(ImageView)findViewById(R.id.backdrop);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        //        为 BottomNavigationView 的菜单项  设置监听事件
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //为 ViewPager 设置监听事件
        viewPager.addOnPageChangeListener(viewPageChangeListener);
        //禁止ViewPager滑动
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        // 为ViewPager设置Adapter
        setupViewPager(viewPager);
        initHeaderAndFooter();

    }
    private void initHeaderAndFooter() {
        mAppBarLayout.post(new Runnable() {
            @Override
            public void run() {
                mAppBarHeight = mAppBarLayout.getHeight();
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_1:
                    setAppLayoutHeight(mAppBarHeight);
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_2:
                    setAppLayoutHeight(0);
                    viewPager.setCurrentItem(1);
                    //imageHead.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_3:
                    setAppLayoutHeight(0);
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_4:
                    setAppLayoutHeight(0);
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };
    private void setAppLayoutHeight(int height) {
        ViewGroup.LayoutParams layoutParams = mAppBarLayout.getLayoutParams();
        layoutParams.height = height;
        mAppBarLayout.setLayoutParams(layoutParams);
    }
    private ViewPager.OnPageChangeListener viewPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
//                if (menuItem != null) {
//                    menuItem.setChecked(false);
//                } else {
//                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
//                }
//                menuItem = bottomNavigationView.getMenu().getItem(position);
//                menuItem.setChecked(true);
            navigation.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    private void setupViewPager(ViewPager viewPager) {
        MainActivityViewPagerAdapter adapter = new MainActivityViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new NavoneFragment());
        adapter.addFragment(new NavtwoFragment());
        adapter.addFragment(new NavthreeFragment());
        adapter.addFragment(new NavfourFragment());
        viewPager.setAdapter(adapter);
    }


}
