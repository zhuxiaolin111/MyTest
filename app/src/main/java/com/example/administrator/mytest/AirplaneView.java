package com.example.administrator.mytest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 16-5-13.
 */
public class AirplaneView  extends View implements View.OnDragListener,View.OnTouchListener{

    float x = 200;
    float y = 300;

    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.airplane);

    public AirplaneView(Context context) {
        super(context);
    }

    public AirplaneView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(bitmap,x,y,p);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int eventaction = event.getAction();



        // touch down so check if the finger is on a ball

                switch(event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_MOVE:
                        int x1=(int)event.getX(1);

                        int y1=(int)event.getY(1);
                        x = x1;
                        y = y1;
                        if(x<0)
                            x=0;
                        this.invalidate();
                        break;
                    default:
                        break;

        }
        // redraw the canvas
        invalidate();
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        x = event.getX();
        y = event.getY();
        invalidate();
        return false;
    }
}
