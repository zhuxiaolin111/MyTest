package com.example.administrator.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Zxl_32Activity extends baseActivity {
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_32layout);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.id);
        ed3 = (EditText) findViewById(R.id.birth);
        ed4 = (EditText) findViewById(R.id.filename);
        ed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Zxl_32Activity.this,Zxl_32Activity_1.class);
                startActivityForResult(i,0);
            }
        });

    }
    public void upimg(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.188:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Zxl_32Interface upi = retrofit.create(Zxl_32Interface.class);
        File file = new File(ed4.getText().toString());
        RequestBody requestBody1 =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Call<Message1> c = upi.uploadStudentInfo(ed2.getText().toString(), ed1.getText().toString(), ed3.getText().toString(), file.getName(),requestBody1 );
       c.enqueue(new Callback<Message1>() {
           @Override
           public void onResponse(Call<Message1> call, Response<Message1> response) {

           }

           @Override
           public void onFailure(Call<Message1> call, Throwable t) {

           }
       });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 123){
            String birth = data.getStringExtra("birth");
            ed4.setText(birth);
        }
    }
}
