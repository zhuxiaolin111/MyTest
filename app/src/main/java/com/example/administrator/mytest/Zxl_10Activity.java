package com.example.administrator.mytest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

/**
 * Created by Administrator on 16-5-23.
 */
public class Zxl_10Activity extends Activity {
    ImageView iv;
    SeekBar sb;
    ProgressBar pb;
    ProgressBar pb1;
    int status = 0;
    RatingBar rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_10layout);
        iv = (ImageView) findViewById(R.id.img);
        rb = (RatingBar) findViewById(R.id.xingxing);
        sb = (SeekBar) findViewById(R.id.sb);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iv.setAlpha(progress);
                //rb.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        status = 0;

        pb = (ProgressBar) findViewById(R.id.jindu);
        pb1 = (ProgressBar) findViewById(R.id.pro);
        final Handler h = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x111) {
                    pb.setProgress(status);
                    status += 10;

                }
                if (status > 100) {
                    pb1.setVisibility(View.GONE);
                }
            }
        };
        new Thread() {
            public void run() {
                while (status <= 100) {
                    // 发送消息到Handler
                    Message m = new Message();
                    m.what = 0x111;
                    // 发送消息
                    h.sendMessage(m);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

//动态改变图片的透明度

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
//rating的是当前星星的数，因为5颗星代表255，除以5是每颗星代表的值
                iv.setImageAlpha((int) rating * 255 / 5);
            }
        });

    }

}

