package com.example.administrator.mytest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Zxl_19Activity extends Activity {
    SharedPreferences sp;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_19layout);

        sp = getSharedPreferences("ex37",MODE_PRIVATE);
        editor = sp.edit();
    }



    public void writeData(View view)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        editor.putString("time",sdf.format(new Date()));
        editor.putInt("rand", (int) (Math.random()*50));
        editor.commit();
    }

    public void readData(View view)
    {
        String time = sp.getString("time","没有存放时间");
        int rand = sp.getInt("rand",-1);
        Toast.makeText(Zxl_19Activity.this, "系统时间是："+time+"，生成的随机数是"+rand, Toast.LENGTH_SHORT).show();
    }
}
