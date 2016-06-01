package com.example.administrator.mytest;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Zxl_14Activity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_14layout);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec page1 = tabHost.newTabSpec("tab1").setIndicator("叫兽").setContent(R.id.isanimal);
        tabHost.addTab(page1);

        TabHost.TabSpec page2 = tabHost.newTabSpec("tab2").setIndicator("老湿").setContent(R.id.alwayswet);
        tabHost.addTab(page2);
        TabHost.TabSpec page3 = tabHost.newTabSpec("tab3").setIndicator("哪吒").setContent(R.id.nezha);
        tabHost.addTab(page3);
    }
}


