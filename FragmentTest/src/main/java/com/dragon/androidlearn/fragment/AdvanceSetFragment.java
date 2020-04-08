package com.dragon.androidlearn.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.OnClick;
import com.dragon.androidlearn.R;
import com.dragon.androidlearn.service.TestServiceActivity;
import com.dragon.androidlearn.service.TestUploadImgActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdvanceSetFragment extends BaseFragment
{
    public AdvanceSetFragment()
    {
        // Required empty public constructor
    }

    @Override
    protected int initContentView()
    {
        return R.layout.fragment_advance_set;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @OnClick({R.id.btn_test1, R.id.btn_test2, R.id.btn_test3, R.id.btn_test4})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                TestServiceActivity.startActivity(getActivity());
                break;

            case R.id.btn_test2:
                TestUploadImgActivity.startActivity(getActivity());
                break;

            case R.id.btn_test3:

                break;

            case R.id.btn_test4:

                break;
        }
    }
}
