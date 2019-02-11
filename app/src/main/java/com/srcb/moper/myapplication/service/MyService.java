package com.srcb.moper.myapplication.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.srcb.moper.myapplication.R;
import com.srcb.moper.myapplication.srcbTest.HandlerActivity;

public class MyService extends Service {

    public static final String TAG = "MyService";

    private MyBinder myBinder = new MyBinder();

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate() executed");
        super.onCreate();
        Intent intent = new Intent(this,HandlerActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, 0);
        Notification notification = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentIntent(pendingIntent)
                            .build();
        startForeground(1,notification);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");

    }

    @Override
    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return myBinder;
    }

    public class MyBinder extends Binder{
        public void done(){

            Log.d("TAG", "startDownload() executed");
			}
    }
}
