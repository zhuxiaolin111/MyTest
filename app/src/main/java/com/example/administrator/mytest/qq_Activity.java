package com.example.administrator.mytest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/30.
 */
public class qq_Activity extends Activity{
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText et1;
    EditText et2;
    Button login;
   CheckBox cb1;
    CheckBox cb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_main);
        login= (Button) findViewById(R.id.qqLoginButton);
        et1= (EditText) findViewById(R.id.qqNum);
        et2= (EditText) findViewById(R.id.qqPassword);
      //  cb1= (CheckBox) findViewById(R.id.qq_login_zidong);
        cb2= (CheckBox) findViewById(R.id.remember_password);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        boolean remember_rb1=pref.getBoolean("remember_account",false);
        boolean remember_rb2=pref.getBoolean("remember_password",false);
        if(remember_rb2){
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            et1.setText(account);
            et2.setText(password);
            cb2.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=et1.getText().toString();
                String password=et2.getText().toString();
                if(account.equals("123")&&password.equals("123")){
                    editor=pref.edit();
                    if(cb2.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }
                    else {
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent=new Intent(qq_Activity.this,HomeWork_Activity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(qq_Activity.this,"这么笨呢...这都猜不对！！！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
