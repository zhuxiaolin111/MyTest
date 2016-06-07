package com.example.administrator.mytest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Zxl_25Activity extends baseActivity implements GestureDetector.OnGestureListener{
    GestureDetector detector;
    ImageView imageView;
    Bitmap bitmap;
    int width,height;
    float cs=1;
    Matrix matrix;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
       setContentView(R.layout.zxl_25layout);
        detector =new GestureDetector(this,this);
        imageView= (ImageView) findViewById(R.id.show);
        matrix=new Matrix();
        bitmap= BitmapFactory.decodeResource(this.getResources(),R.drawable.plane);
        width=bitmap.getWidth();
        height=bitmap.getHeight();
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.plane));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
     //   Toast.makeText(this,"on Down",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
       v=v>4000?4000:v;
        v=v<-4000?-4000:v;
        cs+=cs*v/4000.0f;
        cs+=cs>0.01?cs:0.01f;
        matrix.reset();
        matrix.setScale(cs,cs,160,200);
        BitmapDrawable tmp= (BitmapDrawable) imageView.getDrawable();
        if(!tmp.getBitmap().isRecycled()){
            tmp.getBitmap().recycle();
        }
        Bitmap bitmap2=Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
        imageView.setImageBitmap(bitmap2);
        return true;
    }
}
