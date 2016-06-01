package com.example.administrator.mytest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 16-5-17.
 */
public class Zxl_01Activity extends Activity {
    public int i = 0;
    int alpha = 255;
    ImageView imgView;
    public int[] a = {R.drawable.ccc, R.drawable.ee,
            R.drawable.hb, R.drawable.gg, R.drawable.ji};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_01layout);
        imgView = (ImageView) findViewById(R.id.myImage);
        imgView.setImageResource(a[0]);
    }

    public void shang(View view) {
        imgView.setImageResource(a[Math.abs(--i) % 5]);
    }

    public void xia(View view) {
        imgView.setImageResource(a[Math.abs(++i) % 5]);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void tjia(View view) {
        alpha += 30;
        if (alpha > 255) {
            imgView.setImageAlpha(255);
            alpha = 255;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void tjian(View view){
        alpha-=30;
        if(alpha<0){
            imgView.setImageAlpha(0);
            alpha=0;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }

}
