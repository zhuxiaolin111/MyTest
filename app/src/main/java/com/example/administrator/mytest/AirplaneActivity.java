package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 16-5-13.
 */
public class AirplaneActivity extends Activity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AirplaneView a = new AirplaneView(this);

        setContentView(a);
    }


}
