package com.example.administrator.mytest;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2016/6/16.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate();
    }
}
