package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 果占先 on 2016/6/1.
 */
public class Zxl_27Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Zxl_27View view = new Zxl_27View(this);
        view.setOnTouchListener(view);
        setContentView(view);
    }
}
