package com.srcb.moper.myapplication;

import android.app.Application;

import com.simple.spiderman.SpiderMan;

/**
 * Created by Gjj on 2019/2/12.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //放在其他库初始化前
        SpiderMan.init(this);
    }
}
