package com.example.administrator.mytest;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Zxl_28Activity extends baseActivity {
    VideoView videoView;
   MediaController mediaController;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_28layout);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        videoView= (VideoView) findViewById(R.id.video);
        mediaController=new MediaController(this);

        File video= new File(getFilesDir().getAbsolutePath()+"/myvideo.mp4");//路径

         videoView.setVideoPath(video.getAbsolutePath());
         videoView.setMediaController(mediaController);
         mediaController.setMediaPlayer(videoView);
         videoView.requestFocus();

    }
}
