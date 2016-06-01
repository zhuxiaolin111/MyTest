package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Zxl_15Actyvity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        love_Activity love = new love_Activity(this);
        love.setOnTouchListener(love);
         setContentView(love);
    }
}
