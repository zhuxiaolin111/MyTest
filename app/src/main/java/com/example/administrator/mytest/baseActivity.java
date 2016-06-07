package com.example.administrator.mytest;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class baseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
        //setContentView(R.layout.toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
         toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.zuozhe:
                        AlertDialog.Builder b = new AlertDialog.Builder(baseActivity.this);
                        b.setTitle("作者");
                        b.setMessage("朱晓琳");
                        b.create().show();
                        break;
                    case R.id.fenxiang:
                        Toast.makeText(baseActivity.this, "分享", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        getSupportActionBar().setTitle("地煞");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mif = new MenuInflater(this);
        mif.inflate(R.menu.tool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(this, HomeWork_Activity.class);
                startActivity(intent);
                //  Toast.makeText(this, "已经1", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    protected abstract void initContentView(Bundle savedInstanceState);

}
