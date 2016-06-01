package com.example.administrator.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.example.administrator.mytest.bean.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 16-5-18.
 */
public class Zxl_02Acticity extends Activity {
    List<Student> list = new ArrayList<Student>();

    List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_02layout);

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();
        Student s6 = new Student();
        Student s7 = new Student();
        Student s8 = new Student();
        s1.setName("张三");
        s2.setName("张三2");
        s3.setName("张三3");
        s4.setName("张三4");
        s5.setName("张三5");
        s6.setName("张三6");
        s7.setName("张三7");
        s8.setName("张三8");
        s1.setAge(22);
        s2.setAge(22);
        s3.setAge(22);
        s4.setAge(22);
        s5.setAge(22);
        s6.setAge(22);
        s7.setAge(22);
        s8.setAge(22);
        s1.setPic(R.drawable.icon11);
        s2.setPic(R.drawable.icon28);
        s3.setPic(R.drawable.icon37);
        s4.setPic(R.drawable.icon33);
        s5.setPic(R.drawable.icon30);
        s6.setPic(R.drawable.icon33);
        s7.setPic(R.drawable.icon37);
        s8.setPic(R.drawable.icon37);
        Collections.addAll(list,s1,s2,s3,s4,s5,s6,s7,s8);
        for(Student ss:list)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("studName",ss.getName());
            map.put("studAge",ss.getAge());
            map.put("studPic",ss.getPic());

            res.add(map);
        }

        ListView view = (ListView) findViewById(R.id.studList);
      SimpleAdapter sa = new SimpleAdapter(this,res,R.layout.zxl_row_02layout,new String[]{"studName","studAge","studPic"},new int[]{R.id.studName,R.id.studAge,R.id.studPic});
       view.setAdapter(sa);
     /*   MyAdpater ad = new MyAdpater();
        view.setAdapter(ad);*/
    }

/*    class MyAdpater extends BaseAdapter
    {
        @Override
        public int getCount() {
            return res.size();
        }

        @Override
        public Object getItem(int position) {
            return res.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = LayoutInflater.from(Zxl_02Acticity.this);
            View view = li.inflate(R.layout.zxl_row_02layout,null);

            ImageView iv = (ImageView) view.findViewById(R.id.studPic);
            TextView nameTv = (TextView) view.findViewById(R.id.studName);
            TextView ageTv = (TextView) view.findViewById(R.id.studAge);

            Map<String,Object> obj = res.get(position);
            iv.setImageResource((int) obj.get("studPic"));
            nameTv.setText((String) obj.get("studName"));
            ageTv.setText((int) obj.get("studAge")+"");

            return view;
        }*/
    }


