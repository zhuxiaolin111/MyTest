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
    ,"计算器","飞机","浏览器","霓虹灯","天气查询","intent_dome","打电话","选项卡","画心","获取网络图片","拳皇动画","文件存储",
            "SharedPreferences存储","SQlite","飞机游戏","小球","百度文字识别","手势识别","保存手势","图片手势缩放","画板","图片旋转","录音","播放视频"};
    Class[] c={Zxl_01Activity.class,Zxl_02Acticity.class,Zxl_03Acticity.class,Zxl_04Acticity.class,Zxl_06Activity.
            class,Zxl_07Activity.class,Zxl_09Activity.class,Zxl_10Activity.class,Zxl_11Activity.class,qq_Activity.class,
    login_Activity.class,jisuanqi_Activity.class,Feiji.class,web.class,Deng_Activity.class,Weather_Activity.class,Zxl_12Activity.class
    ,Zxl_13Activity.class,Zxl_14Activity.class,Zxl_15Actyvity.class,Zxl_16Activity.class,Zxl_17Activity.class,Zxl_18Activity.class,
            Zxl_19Activity.class,Zxl_20Activity.class,Activity09_1.class,BallActivity.class,Zxl_21Activity.class,zxl_22Activity.class,
            Zxl_23Activity.class,Zxl_25Activity.class,Zxl_26Activity.class,Zxl_27Activity.class,Zxl_29Activity.class,Zxl_28Activity.class};
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
