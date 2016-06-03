package com.example.administrator.mytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.example.administrator.mytest.bean.Zidan;

/**
 * Created by hasee on 2016/5/26.
 */
public class View091 extends ImageView {

    int bkimg=10;//背景图片每次移动距离

    private float lastX = 300;
    private float lastY = 500;

    float dx;
    float dy;

    Timer t;
    Timer t1;
    Timer t2;
    boolean flag = true;
    Matrix m;
    MediaPlayer mp;


    List<Zidan> list = new ArrayList<Zidan>();
    List<Diji> dijis = new ArrayList<Diji>();

    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.airplane);
    Bitmap bitback = BitmapFactory.decodeResource(getResources(),
            R.drawable.back);
    Bitmap bit3 ;
    Bitmap bit4 =  BitmapFactory.decodeResource(getResources(),
            R.drawable.airplane);

    Bitmap bitboom = BitmapFactory.decodeResource(getResources(),R.drawable.ee); // 爆炸动画


    int width ;
    int height ;

    int airplanewidth ;

    DisplayMetrics dm;
    float sw;
    float sh;

    AnimationDrawable anim;

    Message msg;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }
    };

    // 屏幕的宽高
/*	int width = wm.getDefaultDisplay().getWidth();
	int height = wm.getDefaultDisplay().getHeight();

	private int screenWidth = width; // 屏幕宽度
	private int screenHeight = height; // 屏幕高度
*/
    public View091(Context context) {
        super(context);
        t = new Timer();
        t1 = new Timer();
        t2 = new Timer();
        m = new Matrix();
        msg = new Message();
        mp = MediaPlayer.create(context,R.raw.bomb);
        dm = getResources().getDisplayMetrics();
        airplanewidth = bit4.getWidth();
        sw = dm.widthPixels;
        sh = dm.heightPixels;
       width = bitback.getWidth();
        height = bitback.getHeight();
        m.postScale(1.8f,2.5f);
         bit3 = Bitmap.createBitmap(bitback,0,0,width,height,m,true);
    }



    public View091(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

       canvas.drawBitmap(Bitmap.createBitmap(bit3,0,bkimg,1080,1800),0,0,p);
        bkimg +=20;
        if(bkimg+1800>=bit3.getHeight()){
            bkimg = 0;
        }
        /*canvas.drawBitmap(bit3,0,0,p);*/
        canvas.drawBitmap(bitmap, lastX, lastY, p);

        p.setStrokeWidth(10);
        p.setColor(Color.RED);




        if(dijis.size() != 0){
            for(int i=dijis.size()-1;i>=0;i--){
                Diji d = dijis.get(i);
                d.setY(d.getY()+100);
                canvas.drawBitmap(bit4,d.getX(),d.getY(),p);
                if(d.getY()>sh ){
                    dijis.remove(i--);
                }
            }
        }
        if(list.size() != 0){
            for(int i=list.size()-1;i>=0;i--){
                Zidan z = list.get(i);
                z.setY(z.getY()-30);
                for(int j=dijis.size()-1;j>=0;j--){
                    Diji d = dijis.get(j);
                    if(z.getX()<d.getX()+airplanewidth && z.getX()>d.getX() && z.getY()>d.getY() && z.getY()<d.getY()+airplanewidth){
                        dijis.remove(j--);
                    }
                }
                canvas.drawLine(z.getX(), z.getY(), z.getX(), z.getY() - z.getSize(), p);
                if(z.getY()<0){
                    list.remove(i--);
                }
            }
        }


		/*canvas.drawLine(lastX, lastY, lastX, 0, p);*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        if(getLeft()<x && getRight()>x && getTop()<y && getBottom()>y){
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dx = x - lastX;
                    dy = y - lastY;
                    if(flag){
                        refresh();
                        flag = false;
                    }
                    addZidan();
                    addDiji();
                case MotionEvent.ACTION_MOVE:
                    lastX = x - dx;
                    lastY = y - dy;
                    break;
                case MotionEvent.ACTION_UP:
                    t.cancel();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public void setZidan(){
        Zidan zd = new Zidan();
        zd.setX(lastX);
        zd.setY(lastY);
        zd.setSize(20);
        list.add(zd);
    }

    public void addZidan(){
            t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    setZidan();
                }
            },0,1000);

    }
    public void refresh(){
        t1 = new Timer();
        t1.schedule(new TimerTask() {
            @Override
            public void run() {
                h.sendMessage(new Message());
            }
        },0,80);
    }

    public void setdiji(){
        int dx = (int)(Math.random()*900)+20;
        Diji diji = new Diji();
        diji.setX(dx);
        diji.setY(-150);
        dijis.add(diji);
    }

    public void addDiji(){
        t2 = new Timer();
        t2.schedule(new TimerTask() {
            @Override
            public void run() {
                setdiji();
            }
        },0,4000);
    }
}
