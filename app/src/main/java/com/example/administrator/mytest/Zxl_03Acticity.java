package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 16-5-18.
 */
public class Zxl_03Acticity extends Activity {
    String[] arr = {"沈阳","北京","哈尔滨","上海","深圳"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_03layout);

        ListView view = (ListView) findViewById(R.id.cityList);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        view.setAdapter(ad);
    }
}
