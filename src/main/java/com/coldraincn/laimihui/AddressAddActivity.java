package com.coldraincn.laimihui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.coldraincn.laimihui.entity.Address;
import com.coldraincn.laimihui.entity.Area;
import com.coldraincn.laimihui.presenter.AddressAddPresenter;
import com.coldraincn.laimihui.view.AddressAddView;
import com.coldraincn.laimihui.widget.addressselector.BottomDialog;
import com.coldraincn.laimihui.widget.addressselector.DataProvider;
import com.coldraincn.laimihui.widget.addressselector.ISelectAble;
import com.coldraincn.laimihui.widget.addressselector.SelectedListener;
import com.coldraincn.laimihui.widget.addressselector.Selector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p>
 *          Create by 2017/9/11 14:37
 */

public class AddressAddActivity extends AppCompatActivity{
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";

    private String token;
    private AddressAddPresenter mAddressAddPresenter = new AddressAddPresenter(this);
    private Selector mSelector;
    private BottomDialog mDialog;

    private String name, detailAddress, phone;
    private int provinceCode = 0, cityCode = 0, areaCode = 0, isDefault = 0;

    @BindView(R.id.tv_address_select)
    TextView tv_address_select;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_detail_address)
    EditText et_detail_address;
    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.cb_default)
    CheckBox cb_default;

    @OnClick(R.id.tv_address_select)
    void clickAddress(){
        mDialog.show();
    }
    @OnClick(R.id.bt_back)
    void clickBack(){
        onBackPressed();
    }

    @OnClick(R.id.bt_modify)
    void clickModify(){
        name = et_name.getText().toString();
        detailAddress = et_detail_address.getText().toString();
        phone = et_phone.getText().toString();
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(detailAddress) || TextUtils.isEmpty(phone)
                || provinceCode == 0){
            Toast.makeText(getApplicationContext(), "请输入所有内容", Toast.LENGTH_SHORT).show();
            return;
        }
        if(detailAddress.length() > 59){
            Toast.makeText(getApplicationContext(), "详细地址在60字以内", Toast.LENGTH_SHORT).show();
            return;
        }
        Address address = new Address();
        address.getData().setAreaCode(areaCode);
        address.getData().setCityCode(cityCode);
        address.getData().setProvinceCode(provinceCode);
        address.getData().setIsDefault(isDefault);
        address.getData().setPostCode("000000");
        address.getData().setReceiverAddress(detailAddress);
        address.getData().setReceiverName(name);
        address.getData().setReceiverPhoneNo(phone);
        mAddressAddPresenter.addAddress(token, address);
    }

    private AddressAddView mAddressAddView = new AddressAddView() {
        @Override
        public void onError(String result) {
            Toast.makeText(getApplicationContext(), "新增失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAddSuccess() {
            Toast.makeText(getApplicationContext(), "新增成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_add);
        ButterKnife.bind(this);
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        mAddressAddPresenter.onCreate();
        mAddressAddPresenter.attachView(mAddressAddView);
        initSelector();
        initCheckBox();
    }

    private void initCheckBox() {
        cb_default.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isDefault = b?1:0;
            }
        });
    }

    public static void start(Context context){
        Intent intent = new Intent(context, AddressAddActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化时间选择器
     */
    private void initSelector() {
        mSelector = new Selector(this, 3);

        mSelector.setDataProvider(new DataProvider() {
            @Override
            public void provideData(int currentDeep, int preId, final DataReceiver receiver) {
                //根据tab的深度和前一项选择的id，获取下一级菜单项
                mAddressAddPresenter.getAreaData(token, preId, new AddressAddPresenter.AreaListener() {
                    @Override
                    public void success(final Area area) {
                        ArrayList<ISelectAble> data = new ArrayList<>();
                        for(final Area.DataBean dataBean : area.getData()) {
                            data.add(new ISelectAble() {
                                @Override
                                public String getName() {
                                    return dataBean.getArea();
                                }

                                @Override
                                public int getId() {
                                    return dataBean.getAreaid();
                                }

                                @Override
                                public Object getArg() {
                                    return null;
                                }
                            });
                        }
                        receiver.send(data);
                    }
                });
            }
        });
        mSelector.setSelectedListener(new SelectedListener() {
            @Override
            public void onAddressSelected(ArrayList<ISelectAble> selectAbles) {
                String result = "";
                for (ISelectAble selectAble : selectAbles) {
                    if(selectAble != null) {
                        result += selectAble.getName() + " ";
                    }
                }
                for(int i = 0; i < selectAbles.size(); i++){
                    if(selectAbles.get(i) == null){
                        break;
                    }
                    if(i == 0){
                        provinceCode = selectAbles.get(i).getId();
                    }
                    if(i == 1){
                        cityCode = selectAbles.get(i).getId();
                    }
                    if(i == 2){
                        areaCode = selectAbles.get(i).getId();
                    }
                }
                tv_address_select.setText(result);
                mDialog.dismiss();
            }
        });
        mDialog = new BottomDialog(this);
        mDialog.init(this,mSelector);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAddressAddPresenter.onStop();
    }
}
