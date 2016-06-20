package com.example.administrator.mytest;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/17.
 */
public class Zxl_33Activity extends baseActivity {
    @BindView(R.id.txt)
    EditText txt;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_33layout);
    }

    @OnClick(R.id.btn)
    public void hello(View view) {
        txt.setText("Hello world" + new Date());
    }
}
