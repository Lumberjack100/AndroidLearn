package com.dragon.androidlearn.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.dragon.androidlearn.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceDetailsFragment extends BaseFragment
{

    public DeviceDetailsFragment()
    {
        // Required empty public constructor
    }

    @Override
    protected int initContentView()
    {
        return R.layout.fragment_device_details;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);


        return view;
    }


}
