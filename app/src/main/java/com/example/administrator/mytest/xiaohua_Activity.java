package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.mytest.bean.xiaohua;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/30.
 */
public class xiaohua_Activity extends Activity {
    TextView result;
    EditText weather;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_layout);
        weather = (EditText) findViewById(R.id.weather);
        result = (TextView) findViewById(R.id.result);
        listView= (ListView) findViewById(R.id.lv);

    }
    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String str = (String) b.get("str");

            Gson gson = new Gson();
            xiaohua w1= gson.fromJson(str,xiaohua.class);
            //weather pc = gson.fromJson(str, weather.class);

                //    result.setText(w.getRetData().);


                List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();
                List<xiaohua.ResBodyBean.JokeListBean> l = w1.getRes_body().getJokeList();
                for (xiaohua.ResBodyBean.JokeListBean w : l) {
                    Map<String, Object> m = new HashMap<String, Object>();
                    m.put("province_cn", w.getJokeTitle());
                    m.put("district_cn", w.getJokeContent());
                    m.put("name_cn", w.getBillNo());

                    res.add(m);
                }
                SimpleAdapter sa = new SimpleAdapter(xiaohua_Activity.this, res, R.layout.weather_style, new String[]{"province_cn", "district_cn", "name_cn"}
                        , new int[]{R.id.tv1, R.id.tv2, R.id.tv3});
                listView.setAdapter(sa);
                listView.setTextFilterEnabled(true);

            }

    };
  public void findweather(View view) {
      (new Thread(new Runnable() {
          @Override
          public void run() {
              String httpUrl = "http://apis.baidu.com/hihelpsme/chinajoke/getjokelist";
              BufferedReader reader = null;
              String result = null;
              StringBuffer sbf = new StringBuffer();
              httpUrl = httpUrl + "?page1";

              try {
                  URL url = new URL(httpUrl);
                  HttpURLConnection connection = (HttpURLConnection) url
                          .openConnection();
                  connection.setRequestMethod("GET");
                  // 填入apikey到HTTP header
                  connection.setRequestProperty("apikey",  "562bafef6007883e2e8fffbbdfa9e6ac");
                  connection.connect();
                  InputStream is = connection.getInputStream();
                  reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                  String strRead = null;
                  while ((strRead = reader.readLine()) != null) {
                      sbf.append(strRead);
                      sbf.append("\r\n");
                  }
                  reader.close();
                  result = sbf.toString();
                  Message m = new Message();
                  Bundle b = new Bundle();
                  b.putSerializable("str", result);
                  m.setData(b);
                  h.sendMessage(m);

              } catch (Exception e) {
                  e.printStackTrace();
              }
          }

      })).start();
  }
}
