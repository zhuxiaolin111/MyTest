package com.example.administrator.mytest;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.mytest.bean.gupiao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Zxl_31Activity extends baseActivity {
    EditText et1;
    EditText et2;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
           setContentView(R.layout.zxl_31layout);
        et1= (EditText) findViewById(R.id.num);
        et2= (EditText) findViewById(R.id.gupiao);

    }
    public void gupiao1(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Zxl_31interface baidu = retrofit.create(Zxl_31interface.class);
        Call<gupiao> call = baidu.getPhoneInfo("3024f5f94a02a17d7cf8882c2d5c65a6",et1.getText().toString());

        call.enqueue(new Callback<gupiao>() {
            @Override
            public void onResponse(Call<gupiao> call, Response<gupiao> response) {
                gupiao pc = response.body();
                et2.setText(pc.getRetData().getStockinfo().getName());
            }

            @Override
            public void onFailure(Call<gupiao> call, Throwable t) {

            }
        });
    }
}
