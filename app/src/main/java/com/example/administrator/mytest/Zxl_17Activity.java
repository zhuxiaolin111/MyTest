package com.example.administrator.mytest;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 果占先 on 2016/6/1.
 */
public class Zxl_17Activity extends Activity {
    ImageView iv;

    AnimationDrawable ad;

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_17layout);

        iv = (ImageView) findViewById(R.id.animIv);
        ad = (AnimationDrawable) iv.getBackground();
    }

    public void play(View view)
    {
        ad.start();
        if(music == null)
        {
            music = MediaPlayer.create(this,R.raw.bomb);
        }
        music.start();
    }

    public void stop(View view)
    {
        ad.stop();
    }
}
