package com.dragon.androidlearn.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.dragon.androidlearn.R;
import timber.log.Timber;

public class TestServiceActivity extends AppCompatActivity
{
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TestServiceActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_startService, R.id.btn_stopService})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_startService:
                Timber.tag("Call HelloIntentService").d("Name=" + Thread.currentThread().getName() + ";Id=" + Thread.currentThread().getId() + "");
                Intent startIntent = new Intent(this, HelloIntentService.class);
                startService(startIntent);
                break;

            case R.id.btn_stopService:
                Intent stopIntent = new Intent(this, HelloIntentService.class);
                stopService(stopIntent);
                break;
        }
    }
}
