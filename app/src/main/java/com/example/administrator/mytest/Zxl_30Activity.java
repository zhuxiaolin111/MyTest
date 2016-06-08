package com.example.administrator.mytest;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Zxl_30Activity extends baseActivity {
    File file;
    MediaRecorder recorder;
    MediaPlayer mediaPlayer;
    SurfaceView sv;

    boolean running;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_30layout);

        sv = (SurfaceView) findViewById(R.id.sView);
        sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        sv.getHolder().setFixedSize(320, 280);
        sv.getHolder().setKeepScreenOn(true);
    }

    public void record(View view) {
        file = new File(getFilesDir().getAbsolutePath()+"/myvideo.mp4");

        try {
            recorder = new MediaRecorder();
            recorder.reset();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
            // recorder.setVideoSize(320,280);
            recorder.setVideoFrameRate(4);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.setPreviewDisplay(sv.getHolder().getSurface());

            recorder.prepare();
            recorder.start();
            running = true;
        } catch (Exception e) {
            Log.e("error", e.getMessage());
        }
    }

    public void stop(View view) {
        if (running) {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
            running = false;
        }
    }

}
