package com.example.administrator.mytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


import com.example.administrator.mytest.bean.MyPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class love_Activity extends View implements View.OnTouchListener {
    public float xx = 300;
    public float yy = 300;
    List<MyPoint> list = new ArrayList<MyPoint>();
    public love_Activity(Context context) {
        super(context);
    }

    public love_Activity(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setAntiAlias(true);
        p.setStrokeWidth(5);

//        canvas.drawCircle(cx,cy,50,p);
        for(MyPoint point:list)
        {
            p.setColor(point.getColor());
            for(float i=-2;i<=2;i+=0.001)
            {
                float y = (float) Math.sqrt(2*Math.sqrt(i*i)-i*i);
                float y2 = (float) (-2.14*Math.sqrt(Math.sqrt(2)-Math.sqrt(Math.abs(i))));

                canvas.drawPoint(i*150+point.getX(),-y*150+point.getY(),p);
                canvas.drawPoint(i*150+point.getX(),-y2*150+point.getY(),p);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            xx = event.getX();
            yy = event.getY();
            MyPoint p = new MyPoint();
            p.setX(xx);
            p.setY(yy);
            int color = 0xff000000+(int) (Math.random()*0xffffff);
            p.setColor(color);
            list.add(p);
            invalidate();
        }
        return true;
    }
}
