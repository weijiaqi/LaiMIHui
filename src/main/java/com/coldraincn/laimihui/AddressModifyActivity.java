package com.coldraincn.laimihui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.coldraincn.laimihui.entity.GetAddress;
import com.coldraincn.laimihui.presenter.AddressAddPresenter;
import com.coldraincn.laimihui.presenter.AddressModifyPresenter;
import com.coldraincn.laimihui.view.AddressModifyView;
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
 *          Create by 2017/9/11 16:25
 */

public class AddressModifyActivity extends AppCompatActivity {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";

    private String token;
    private static final String BUNDLE_ADDRESS_ID = "bundle_address_id";
    private AddressModifyPresenter mAddressModifyPresenter = new AddressModifyPresenter(this);
    private long mAddressId;

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
    void clickAddress() {
        mDialog.show();
    }

    @OnClick(R.id.bt_back)
    void clickBack() {
        onBackPressed();
    }

    @OnClick(R.id.bt_modify)
    void clickModify() {
        new AlertDialog.Builder(this).setTitle("提示").setMessage("是否确定保存？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
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
                address.getData().setObjectId(mAddressId);
                address.getData().setAreaCode(areaCode);
                address.getData().setCityCode(cityCode);
                address.getData().setProvinceCode(provinceCode);
                address.getData().setIsDefault(isDefault);
                address.getData().setPostCode("000000");
                address.getData().setReceiverAddress(detailAddress);
                address.getData().setReceiverName(name);
                address.getData().setReceiverPhoneNo(phone);
                mAddressModifyPresenter.updateAddress(token, address);
            }
        }).setNegativeButton("取消", null).show();
    }

    @OnClick(R.id.bt_delete)
    void clickDelete() {
        new AlertDialog.Builder(this).setTitle("提示").setMessage("是否确定删除？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mAddressModifyPresenter.deleteAddress(token, mAddressId);
            }
        }).setNegativeButton("取消", null).show();
    }


    private AddressModifyView mAddressModifyView = new AddressModifyView() {
        @Override
        public void onError(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSuccess(GetAddress getAddress) {
            Address address = getAddress.getData();
            if (address == null) {
                return;
            }
            provinceCode = address.getData().getProvinceCode();
            cityCode = address.getData().getCityCode();
            areaCode = address.getData().getAreaCode();
            isDefault = address.getData().getIsDefault();
            et_name.setText(address.getData().getReceiverName());
            et_detail_address.setText(address.getData().getReceiverAddress());
            et_phone.setText(address.getData().getReceiverPhoneNo());
            et_phone.setText(address.getData().getReceiverPhoneNo());
            cb_default.setChecked(address.getData().getIsDefault() == 0 ? false : true);
            tv_address_select.setText(address.getData().getProvince() + " " + address.getData().getCity() + " "  + address.getData().getArea());
        }

        @Override
        public void onUpdateSuccess() {
            Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDeleteSuccess() {
            Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_modify);
        ButterKnife.bind(this);
        SharedPreferences settings = getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        mAddressModifyPresenter.onCreate();
        mAddressModifyPresenter.attachView(mAddressModifyView);
        initSelector();
        initCheckBox();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAddressId = getIntent().getLongExtra(BUNDLE_ADDRESS_ID, 0);
        mAddressModifyPresenter.getAddress(token, mAddressId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAddressModifyPresenter.onStop();
    }

    public static void start(Context context, long addressId) {
        Intent intent = new Intent(context, AddressModifyActivity.class);
        intent.putExtra(BUNDLE_ADDRESS_ID, addressId);
        context.startActivity(intent);
    }

    private void initCheckBox() {
        cb_default.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isDefault = b?1:0;
            }
        });
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
                mAddressModifyPresenter.getAreaData(token, preId, new AddressAddPresenter.AreaListener() {
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
}
