package com.example.administrator.mytest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class BallView extends View implements View.OnTouchListener{

    private int speedx = (int)(Math.random()*40)+10;
    private int speedy = (int)(Math.random()*40)+10;


    private int size = 30;
    private Timer t;

    private int fangxiang=(int)(Math.random()*4+1); //小球初始方向
    private int bianxiang; //小球运动过程中的变像

    WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

    // 屏幕的宽高
    int width = wm.getDefaultDisplay().getWidth();
    int height = wm.getDefaultDisplay().getHeight();

    // 小球的初始位置
    private int x = width/2;
    private int y = height/2;

    int lx = 500;
    int ly = 1400;
    int lwidth=170;

    boolean flag = true;

    String s = "游戏结束";


    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0){
                t.cancel();
            }else{

                fangxiang = msg.what;
            }
            invalidate();
        };
    };

    public BallView(Context context) {
        super(context);
        setBall();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        Paint p1 = new Paint();

        canvas.drawLine(lx-lwidth, ly, lx+lwidth, ly, p1);
        canvas.drawCircle(x, y, size, p);
        if(!flag){
            Paint p2 = new Paint();
            p2.setStrokeWidth(8);
            p2.setTextSize(30);
            p2.setColor(Color.RED);
            canvas.drawText(s, 100, 100, p2);
        }

    }

    public void setBall(){
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m = new Message();
                bianxiang = fangxiang;
                if(fangxiang == 1){
                    x = x-speedx;
                    y = y-speedy;
                    if(x-size<= 0){
                        bianxiang = 2;
                    }
                    if(y-size<=0){
                        bianxiang = 4;
                    }
                }

                if(fangxiang == 2){
                    x = x+speedx;
                    y = y-speedy;
                    if(x+size>= width){
                        bianxiang = 1;
                    }
                    if(y-size<=0){
                        bianxiang = 3;
                    }
                }

                if(fangxiang == 3){
                    x = x+speedx;
                    y = y+speedy;
                    if(x+size> width){
                        bianxiang = 4;
                    }
                    if(y+size>=ly){
                        if(x<=lx+lwidth && x>=lx-lwidth){
                            bianxiang = 2;
                        }else{
                            flag = false;
                        }
                    }
                }

                if(fangxiang == 4){
                    x = x-speedx;
                    y = y+speedy;
                    if(x-size<= 0){
                        bianxiang = 3;
                    }
                    if(y+size>=ly){
                        if(x<=lx+lwidth && x>=lx-lwidth){
                            bianxiang = 1;
                        }else{
                            flag = false;
                        }
                    }
                }
                if(flag){
                    m.what = bianxiang;
                }else{
                    m.what = 0;
                }

                h.sendMessage(m);
            }
        },10,100);
    }

    @Override
    public boolean onTouch(View arg0, MotionEvent e) {
        int i = (int)e.getX();
        if(i+lwidth>width){
            i = width-lwidth;
        }else if(i-lwidth<0){
            i = lwidth;
        }
        lx = i;

        return false;
    }

}
