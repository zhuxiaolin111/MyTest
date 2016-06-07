package com.example.administrator.mytest;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Zxl_21Activity extends baseActivity {
    SpeechSynthesizer speechSynthesizer;
    EditText et;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_21layout);
        et= (EditText) findViewById(R.id.tex);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setAppId("8224361");
       speechSynthesizer.setContext(this);

// 此处需要将setApiKey方法的两个参数替换为你在百度开发者中心注册应用所得到的apiKey和secretKey
        speechSynthesizer.setApiKey("nKP1sSWYZY5Bs6uzGChgfxnY", "fbd3a4a01efd6d41b518f4d00729cc68");
        speechSynthesizer.initTts((TtsMode.ONLINE) );

    }
    public  void bofang(View view){
        speechSynthesizer.speak(et.getText().toString());
    };

}

