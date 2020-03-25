package com.dragon.androidlearn.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * 项目名：  AndroidLearn <br/>
 * 包名：    com.dragon.androidlearn.fragment <br/>
 * 创建者:   gonghe <br/>
 * 创建时间:  2020/3/25 <br/>
 * 描述：    TODO
 */
public abstract class BaseFragment extends Fragment
{
    protected abstract int initContentView();


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "onSaveInstanceState");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(initContentView(), container, false);
        ButterKnife.bind(this, view);

        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onCreateView");
        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        String name = getClass().getSimpleName();

        Timber.tag("LifeCicleTetst").e(name + "  onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onActivityCreated");
    }

    @Override
    public void onStart()
    {
        super.onStart();

        String name = getClass().getSimpleName();
//        Timber.tag("LifeCicleTetst").e(name + "  onStart");
        Log.e("LifeCicleTetst", name + "  Call onStart");
    }


    @Override
    public void onResume()
    {
        super.onResume();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onStop");
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onDestroyView");
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onDestroy");
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onDetach");
    }

}
