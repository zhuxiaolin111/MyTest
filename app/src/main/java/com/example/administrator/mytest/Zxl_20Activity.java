package com.example.administrator.mytest;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Administrator on 2016/6/3.
 */
public class Zxl_20Activity extends baseActivity {
    StudentHelper helper;
    ListView lv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
     setContentView(R.layout.zxl_20layout);
        helper=new StudentHelper(this,"student.db",null,Contants.DB_VERSION);
        lv= (ListView) findViewById(R.id.listview_stu);
        Cursor c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.zxl_row_02layout,c,new String[]{"name","pic","age"},new int[]{R.id.studName,R.id.studPic,R.id.studAge},0);

        lv.setAdapter(aca);
    }
}
