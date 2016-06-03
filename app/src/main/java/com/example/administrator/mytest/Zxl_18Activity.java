package com.example.administrator.mytest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Zxl_18Activity extends Activity {
    EditText et;
    String s;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_18layout);
        et = (EditText) findViewById(R.id.io_edit);
        Button btn = (Button) findViewById(R.id.btn);
        Button btn1 = (Button) findViewById(R.id.btn1);
        tv = (TextView) findViewById(R.id.tv);
        //  s=et.getText().toString();
    }

    private void save(String s) {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try {
            out=openFileOutput("data123", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void save(View view)  {
        s=et.getText().toString();
       // save(s);
       FileOutputStream out=null;
        BufferedWriter writer=null;
        try {
            out=openFileOutput("data1", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Toast.makeText(Zxl_18Activity.this,"保存成功",Toast.LENGTH_SHORT).show();

    }
    public  void read(View view){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder str=new StringBuilder();
        try {
            in=openFileInput("data1");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while((line=reader.readLine())!=null){
                str.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        tv.setText(str.toString());
    }
}
