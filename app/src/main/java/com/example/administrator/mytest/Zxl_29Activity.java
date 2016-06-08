package com.example.administrator.mytest;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Zxl_29Activity extends baseActivity {
    MediaRecorder recorder;
    File file;
    MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_29layout);
    }

    public void record(View view)
    {
        file = new File("/mnt/sdcard/sound.amr");
        try{
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.prepare();
            recorder.start();
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
    }

    public void stop(View view)
    {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
    }
       public void fang(View view){
           file=new File("/mnt/sdcard/sound.amr");
           try {
               mediaPlayer.setDataSource(file.getAbsolutePath());
               mediaPlayer.prepare();
               mediaPlayer.start();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    @Override
    protected void onDestroy() {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        super.onDestroy();
    }
}
