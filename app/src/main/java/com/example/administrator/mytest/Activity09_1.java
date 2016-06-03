package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by hasee on 2016/5/26.
 */
public class Activity09_1 extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View091 view = new View091(this);
        setContentView(view);
    }


}
