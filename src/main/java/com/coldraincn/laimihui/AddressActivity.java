package com.coldraincn.laimihui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.coldraincn.laimihui.adapter.AddressAdapter;
import com.coldraincn.laimihui.adapter.BaseAdapter;
import com.coldraincn.laimihui.entity.AddressList;
import com.coldraincn.laimihui.presenter.AddressPresenter;
import com.coldraincn.laimihui.view.AddressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 13:26
 */

public class AddressActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";

    private String token;
    private AddressPresenter mAddressPresenter = new AddressPresenter(this);
    private AddressAdapter mAddressAdapter;
    private List<AddressList.DataBean> mAddressList = new ArrayList<>();

    @BindView(R.id.rv_address)
    RecyclerView rv_address;
    @OnClick(R.id.bt_add)
    void clickAdd(){
        AddressAddActivity.start(this);
    }

    private AddressView mAddressView = new AddressView() {
        @Override
        public void onSuccess(AddressList data) {
            if(!mAddressList.isEmpty()){
                mAddressList.clear();
            }
            mAddressList.addAll(data.getData());
            mAddressAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        mAddressPresenter.onCreate();
        mAddressPresenter.attachView(mAddressView);
        initAdapter();
    }

    private void initAdapter() {
        mAddressAdapter = new AddressAdapter(this, mAddressList);
        rv_address.setLayoutManager(new LinearLayoutManager(this));
        rv_address.setAdapter(mAddressAdapter);
        mAddressAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position) {
                if (getIntent().getBooleanExtra("select", false)){
                    Intent intent = new Intent();
                    intent.putExtra("address",mAddressList.get(position));
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    AddressModifyActivity.start(AddressActivity.this, mAddressList.get(position).getObjectId());
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAddressPresenter.getAddressList(token);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAddressPresenter.onStop();
    }
}
