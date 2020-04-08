package com.dragon.androidlearn.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import timber.log.Timber;

public class MyService extends Service
{
    private MyBinder mBinder = new MyBinder();

    public MyService()
    {
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Timber.tag("MyService").d("onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Timber.tag("MyService").d("onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Timber.tag("MyService").d("onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    class MyBinder extends Binder
    {
        public void startDownload()
        {
            Timber.tag("MyService").d("startDownload() executed");
            // 执行具体的下载任务
        }
    }
}
