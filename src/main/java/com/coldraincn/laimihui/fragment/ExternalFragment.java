package com.coldraincn.laimihui.fragment;

/**
 * Created by hd on 2017/9/11.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coldraincn.laimihui.R;

public class ExternalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pay_external, container, false);
    }
}
