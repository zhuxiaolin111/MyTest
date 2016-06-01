package com.example.administrator.mytest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Zxl_13Activity extends baseActivity {
    TextView pName;
    TextView phoneNum;
    Intent i;
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.zxl_13layout);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 i = new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("vnd.android.cursor.item/phone");//MIME类型
                startActivityForResult(i,0);
            }
        });

        pName = (TextView) findViewById(R.id.show);
        phoneNum = (TextView) findViewById(R.id.phone);
        Button bn= (Button) findViewById(R.id.home);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent();
                i.setAction(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode== Activity.RESULT_OK)
        {
            Uri uri = data.getData();
            CursorLoader cl = new CursorLoader(this,uri,null,null,null,null);
            Cursor c = cl.loadInBackground();
            if(c.moveToFirst())
            {
                String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phone = "";

                Cursor phoneC = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = "+contactId,null,null);
                while(phoneC.moveToNext())
                {
                    phone = phone + " " + phoneC.getString(phoneC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }

                phoneC.close();

                pName.setText(name);
                phoneNum.setText(phone);
            }
            c.close();
        }
    }

    public void callTheOther(View view)
    {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        String data = "tel:15804099460";
        i.setData(Uri.parse(data));
        startActivity(i);
    }
}
