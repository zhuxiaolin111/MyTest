package com.example.administrator.mytest;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Zxl_12Activity1 extends Activity {
    String[] str={"辽宁","北京","山东"};
    String[][] str1={{"沈阳","大连","鞍山","本溪"},
            {"朝阳区","昌平","海淀区"},{"青岛","济南","聊城","烟台","潍坊"}};
    ExpandableListView elv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_12layout_city);
        elv= (ExpandableListView) findViewById(R.id.city);
         ExpandableListAdapter e=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return str.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return str1[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return str[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return str1[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                TextView v=new TextView(Zxl_12Activity1.this);
                v.setText(str[i]);
                v.setPadding(50,0,0,0);
                v.setTextSize(50);
                return v;

            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView v=new TextView(Zxl_12Activity1.this);
                v.setText(str1[i][i1]);
                v.setPadding(10,0,0,0);
                v.setTextSize(50);
                return v;

            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long l) {return 0;
            }
        };
        elv.setAdapter(e);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
               Intent ii=getIntent();
               ii.putExtra("city",str1[i][i1]) ;
                setResult(111,ii);
                finish();
                return true;
            }
        });
    }
}
