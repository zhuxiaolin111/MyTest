package com.example.administrator.mytest;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class zxl_22Activity extends baseActivity {
    GestureOverlayView gestureOverlayView;
    GestureLibrary gestLib;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_22layout);

        gestLib = GestureLibraries.fromPrivateFile(this,"mygestures");
        if(!gestLib.load())
        {
            Toast.makeText(zxl_22Activity.this, "手势库加载失败！", Toast.LENGTH_SHORT).show();
        }

        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestureView);
        gestureOverlayView.setGestureColor(Color.GREEN);
        gestureOverlayView.setGestureStrokeWidth(5);

        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                List<Prediction> list = gestLib.recognize(gesture);
                for(Prediction p:list)
                {
                    if(p.score>2.0)
                    {
                        Toast.makeText(zxl_22Activity.this, "找到匹配手势！"+p.name+"<<<"+p.score, Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });

    }
}
