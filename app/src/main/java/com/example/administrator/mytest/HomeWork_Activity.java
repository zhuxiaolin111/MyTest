package com.example.administrator.mytest;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/30.
 */
public class HomeWork_Activity extends baseActivity {
    String[] home={"上一张，下一张","适配器","ListView","电话号归属地","下拉列表","显示学历","图片轮换","进度条","相关字搜索","qq界面","登录界面"
    ,"计算器","飞机","浏览器","霓虹灯","天气查询","intent_dome","打电话","选项卡","画心","获取网络图片","拳皇动画"};
    Class[] c={Zxl_01Activity.class,Zxl_02Acticity.class,Zxl_03Acticity.class,Zxl_04Acticity.class,Zxl_06Activity.
            class,Zxl_07Activity.class,Zxl_09Activity.class,Zxl_10Activity.class,Zxl_11Activity.class,qq_Activity.class,
    login_Activity.class,jisuanqi_Activity.class,Feiji.class,web.class,Deng_Activity.class,Weather_Activity.class,Zxl_12Activity.class
    ,Zxl_13Activity.class,Zxl_14Activity.class,Zxl_15Actyvity.class,Zxl_16Activity.class,Zxl_17Activity.class};
    ListView listView;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.homewoek_layout);

        listView = (ListView) findViewById(R.id.listview_homework);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_list_item_1,home);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(HomeWork_Activity.this,c[position]);
                startActivity(i);
            }
        });
    }


}
