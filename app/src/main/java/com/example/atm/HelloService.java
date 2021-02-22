package com.example.atm;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class HelloService extends IntentService {
    public static final String ACTION_HELLO_DONE = "action_hello_done";
    private static final String TAG = HelloService.class.getSimpleName();

    public HelloService() {
        super("HelloService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) { //可以執行耗時工作
        Log.d(TAG, "onHandleIntent: " + intent.getStringExtra("NAME"));
        Log.d(TAG, "onHandleIntent: ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent done = new Intent();
        done.setAction(ACTION_HELLO_DONE);
        sendBroadcast(done);
    }
}
