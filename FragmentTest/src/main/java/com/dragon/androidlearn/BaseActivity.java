package com.dragon.androidlearn;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * 项目名：  AndroidLearn <br/>
 * 包名：    com.dragon.androidlearn <br/>
 * 创建者:   gonghe <br/>
 * 创建时间:  2020/3/25 <br/>
 * 描述：    TODO
 */
public abstract class BaseActivity extends AppCompatActivity
{

    protected abstract int initContentView();

    @Override
    protected void onRestoreInstanceState(Bundle state)
    {
        super.onRestoreInstanceState(state);
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onRestoreInstanceState" + "  " + this.hashCode());
    }


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + " onSaveInstanceState" + "  " + this.hashCode());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(initContentView());
        ButterKnife.bind(this);

        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onCreate" + "  " + this.hashCode());
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onRestart" + "  " + this.hashCode());
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onStart" + "  " + this.hashCode());
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onResume" + "  " + this.hashCode());
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onPause" + "  " + this.hashCode());
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onStop" + "  " + this.hashCode());
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        String name = getClass().getSimpleName();
        Timber.tag("LifeCicleTetst").e(name + "  onDestroy" + "  " + this.hashCode());
    }
}
