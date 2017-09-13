package com.coldraincn.laimihui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.coldraincn.laimihui.entity.OrderList.OrderItem;
import com.coldraincn.laimihui.model.UIOrder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserOrderDetailActivity extends AppCompatActivity
{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView titleView;


    public static void toOrderDetail(Context context, OrderItem item)
    {
        Intent intent = new Intent(context, UserOrderDetailActivity.class);

        intent.putExtra("orderItem", item);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        OrderItem item = (OrderItem) getIntent().getSerializableExtra("orderItem");

        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_order_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.arrow);

        getSupportActionBar().setTitle("");

        titleView.setText("订单详情");

        binding.setVariable(com.coldraincn.laimihui.BR.data, new UIOrder(item));

        binding.executePendingBindings();
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
}
