package com.dragon.androidlearn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity
{

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
            finish();

            handler.removeMessages(-1);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.sendMessageDelayed(handler.obtainMessage(-1), 1000);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            handler.sendMessage(handler.obtainMessage(-1));
        }

        return super.onTouchEvent(event);
    }

}
