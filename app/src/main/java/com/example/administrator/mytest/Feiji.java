package com.example.administrator.mytest;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/** * Created by asus on 2016/5/15. */
public class Feiji extends Activity {
    ImageView imageView = null;
    ImageView imageView1 = null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feiji);
        init();
    }

    private void init() {
        imageView  = (ImageView) this.findViewById(R.id.feiji);
       imageView.setOnTouchListener(new ImageViewOnTouchListener());
}
private final class ImageViewOnTouchListener implements View.OnTouchListener {

PointF startPoint = new PointF();
PointF startPoint1 = new PointF();
Matrix matrix = new Matrix();
public boolean onTouch(View v, MotionEvent event) {
imageView.setImageResource(R.drawable.plane);
//        imageView1= (ImageView) findViewById(R.id.daodan);
//        imageView1.setImageResource(R.drawable.plane);
switch(event.getAction() & MotionEvent.ACTION_MASK){
    case MotionEvent.ACTION_DOWN: //指点杆按下
        // 将当前的坐标保存为起始点
           startPoint1.set(event.getX(),event.getY());
           startPoint.set(event.getX(), event.getY());
          break;
         case MotionEvent.ACTION_MOVE: //指点杆保持按下，并且进行位移
          float dx = event.getX()-startPoint.x;
          float dy = event.getY()-startPoint.y;
          matrix.postTranslate(dx, dy);
         //将当前的坐标保存为新的起始点
         startPoint.set(event.getX(), event.getY());
         break;
          case MotionEvent.ACTION_UP: //指点杆离开屏幕
              imageView.setImageResource(R.drawable.airplane);
         break;
          case MotionEvent.ACTION_POINTER_UP: //有手指头离开屏幕，但还有没离开的
           break;
         case MotionEvent.ACTION_POINTER_DOWN: //如果已经有手指压在屏幕上，又有一个手指压在了屏幕上
         break;           }
         imageView.setImageMatrix(matrix);

         return true;
}
}
}





