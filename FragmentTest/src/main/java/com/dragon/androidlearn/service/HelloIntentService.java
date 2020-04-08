package com.dragon.androidlearn.service;

import android.app.IntentService;
import android.content.Intent;
import timber.log.Timber;

public class HelloIntentService extends IntentService
{

    /**
     * A constructor is required, and must call the super <code><a href="/reference/android/app/IntentService.html#IntentService(java.lang.String)">IntentService(String)</a></code>
     * constructor with a name for the worker thread.
     */
    public HelloIntentService()
    {
        super("HelloIntentService");
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent)
    {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try
        {
            Timber.tag("HelloIntentService").d("Name=" + Thread.currentThread().getName() + ";Id=" + Thread.currentThread().getId() + "");
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
}
