package com.example.administrator.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Zxl_12Activity extends baseActivity {
    EditText et;
    Intent intent;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_12layout);
        et= (EditText) findViewById(R.id.edit_city);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Zxl_12Activity.this,Zxl_12Activity1.class);
                startActivityForResult(intent,0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==111){
            String city=data.getStringExtra("city");
            et.setText(city);
        }
    }
}
