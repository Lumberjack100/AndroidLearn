package com.dragon.androidlearn;

import android.app.Application;

/**
 * 项目名：  AndroidLearn <br/>
 * 包名：    com.dragon.androidlearn <br/>
 * 创建者:   gonghe <br/>
 * 创建时间:  2020/3/25 <br/>
 * 描述：    TODO
 */
public class MyApplication extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();

    }


    /**
     * 设置日志输出
     */
    private void initTimber() {
//        Timber.d("initTimber()------in");
//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//        } else {
//            Timber.plant(new CrashReportingTree());
//        }
    }
}
