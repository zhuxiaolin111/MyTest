package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Administrator on 16-5-19.
 */
public class Zxl_07Activity extends Activity {
    String[] str={"高中","专科","本科","研究生","博士"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_07layout);
        Spinner spinner = (Spinner) findViewById(R.id.xiala);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, str);
        spinner.setAdapter(aa);

    }
}
