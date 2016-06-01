package com.example.administrator.mytest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


/**
 * Created by Administrator on 16-5-24.
 */
public  class Zxl_11Activity extends baseActivity {
    SearchView searchView;
    ListView lv;
    TextView textView;

     String[] str = {"asd", "asc", "qq", "qw", "as", "asdf"};


   @Override
    protected void initContentView(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.zxl_11layout);
        textView = (TextView) findViewById(R.id.tv);
        searchView = (SearchView) findViewById(R.id.sh);
        lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, str);
        lv.setAdapter(aa);
        lv.setTextFilterEnabled(true);
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() != 0) {
                    lv.setFilterText(newText);
                } else {
                    lv.clearTextFilter();
                }
                return true;
            }

        });
    }

}