package com.dragon.androidlearn.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.dragon.androidlearn.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueryDeviceDataFragment extends BaseFragment
{
    @BindView(R.id.edit_text)
    EditText editText;

    public QueryDeviceDataFragment()
    {
        // Required empty public constructor
    }

    @Override
    protected int initContentView()
    {
        return R.layout.fragment_query_device_data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);


        return view;
    }


}
