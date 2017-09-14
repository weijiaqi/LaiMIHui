package com.coldraincn.laimihui.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coldraincn.laimihui.AddressActivity;
import com.coldraincn.laimihui.ChangeInfoActivity;
import com.coldraincn.laimihui.LoginActivity;
import com.coldraincn.laimihui.ManageShopActivity;
import com.coldraincn.laimihui.MyOrdersActivity;
import com.coldraincn.laimihui.R;
import com.coldraincn.laimihui.WeixinActivity;
import com.coldraincn.laimihui.widget.RoundImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavfourFragment extends Fragment {
    public static final String PREFUSER = "USER";
    public static final String PREF_CELL = "CELL";
    public static final String PREF_TOKEN = "TOKEN";
    public static final String PREF_CID = "CID";
    public static final String PREF_USERROLE = "USERROLE";
    public static final String PREF_IMAGE = "IMAGE";
    public static final String PREF_NAME = "NAME";
    @BindView(R.id.myorders)
    RelativeLayout myorders;

    private String token;
    private String name;
    private String image;
    private String id;
    private String role;


    @BindView(R.id.circleImageview)
    RoundImageView circleImageview;
    @BindView(R.id.textname)
    TextView textname;
    @BindView(R.id.textvip)
    TextView textvip;
    @BindView(R.id.buttonmessage)
    ImageButton buttonmessage;
    @BindView(R.id.buttonmanege)
    Button buttonmanege;
    @BindView(R.id.order_icon)
    ImageView orderIcon;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.buttonorder1)
    Button buttonorder1;
    @BindView(R.id.buttonorder2)
    Button buttonorder2;
    @BindView(R.id.buttonorder3)
    Button buttonorder3;
    @BindView(R.id.wallet_icon)
    ImageView walletIcon;
    @BindView(R.id.wallet_view_line)
    View walletViewLine;
    @BindView(R.id.card_icon)
    ImageView cardIcon;
    @BindView(R.id.card_view_line)
    View cardViewLine;
    @BindView(R.id.myinfo)
    Button myinfo;
    @BindView(R.id.myaddress)
    Button myaddress;
    @BindView(R.id.buttonlogout)
    Button buttonlogout;
    Unbinder unbinder;

    @OnClick(R.id.buttonlogout)
    public void logout() {
        getActivity().finish();
        SharedPreferences settings = getActivity().getSharedPreferences(PREFUSER, 0);
        settings.edit().clear().apply();
        startActivity(new Intent(getActivity(), LoginActivity.class));

    }
    @OnClick(R.id.myorders)
    public void setMyorders() {
        Intent intent = new Intent (getActivity(),MyOrdersActivity.class);
        startActivity(intent);


    }
    @OnClick(R.id.myinfo)
    public void myinfo() {
        Intent intent = new Intent (getActivity(),ChangeInfoActivity.class);
        startActivity(intent);


    }
    @OnClick(R.id.myaddress)
    public void address() {
        Intent intent = new Intent (getActivity(),AddressActivity.class);
        startActivity(intent);


    }
    @OnClick(R.id.buttonmanege)
    public void manage() {
        Intent intent = new Intent (getActivity(),ManageShopActivity.class);
        startActivity(intent);


    }

    public NavfourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navfour, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences settings = getActivity().getSharedPreferences(PREFUSER, 0);
        token = settings.getString(PREF_TOKEN, "1");
        name = settings.getString(PREF_NAME, "1");
        image = settings.getString(PREF_IMAGE, "");
        role = settings.getString(PREF_USERROLE, "");
        id = settings.getString(PREF_CID, "");
        if (!image.equals("")) {
            Picasso.with(getActivity()).load(image).into(circleImageview);
        }
        /**
         *

        textname.setText(name);
        if (role.equals("1")) {
            buttonmanege.setVisibility(View.INVISIBLE);
        }
         */

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
