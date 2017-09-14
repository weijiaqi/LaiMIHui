package com.coldraincn.laimihui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ManageShopActivity extends AppCompatActivity  implements View.OnClickListener{


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_my_shop)
    LinearLayout llMyShop;
    @BindView(R.id.shop_manager)
    LinearLayout shopManager;
    @BindView(R.id.ll_manage_order)
    LinearLayout llManageOrder;
    @BindView(R.id.vip_manager)
    LinearLayout vipManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_shop);
        ButterKnife.bind(this);
        llMyShop.setOnClickListener(this);
        shopManager.setOnClickListener(this);
        vipManager.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_my_shop:
                Intent myshop = new Intent(this, PersronStoresActivity.class);  //跳转到我的管理
                startActivity(myshop);
                break;
            case R.id.vip_manager:
                Intent shopmanager=new Intent(this, MemshipManagerActivity.class); //跳转到会员店管理
                startActivity(shopmanager);
                break;
            case R.id.shop_manager:
                Intent llmanager=new Intent(this, CommodityManagerActivity.class); //跳转到商品管理
                startActivity(llmanager);
                break;
        }

    }
}
