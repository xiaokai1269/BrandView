package com.wangkai.brandview.fragement;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangkai.brandview.R;

/**
 * Created by wangkai on 16/7/13.
 */
public class HomeFragment extends Fragment{

    public static final String TAG = HomeFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_home , container ,false);
        return view;
    }
}
