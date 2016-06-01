package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;

public class BallActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        BallView b = new BallView(this);
        b.setOnTouchListener(b);
		/*MoveImageView b = new MoveImageView(this);*/
        setContentView(b);
    }
}



