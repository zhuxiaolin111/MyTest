package com.example.administrator.mytest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MyComputer on 2016/5/15.
 */
public class Deng_Activity extends AppCompatActivity {

    int m=0;

    int[] colors={
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
    };
    int[] names={
            R.id.view1,
            R.id.view2,
            R.id.view3,
            R.id.view4,
            R.id.view5,
            R.id.view6,
    };
    TextView[] views=new TextView[names.length];
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                for (int i=0;i<names.length;i++){
                    views[i].setBackgroundResource(colors[(i+m)%names.length]);
                }
                m++;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deng_layout);
        for (int n=0;n<names.length;n++){
            views[n]= (TextView) findViewById(names[n]);
        }
           new Timer().schedule(new TimerTask() {
               @Override
               public void run() {
                   handler.sendEmptyMessage(1);
               }
           },0,500);
    }
}