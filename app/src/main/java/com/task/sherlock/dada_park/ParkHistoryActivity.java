package com.task.sherlock.dada_park;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkHistoryActivity extends AppCompatActivity {
    private ListView listView;
    private int park_number;

    private String[] data=new String [100];
    private String[] time_length=new String [100];
    private String[] cost=new String[100];
    private String[] position=new String[100];

    public Remember_spot_list<String> list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=new Intent();
        park_number=intent.getIntExtra("park_number",1);
        list_item= (Remember_spot_list<String>) getApplicationContext();
//      Log.d("MarkDowanTest","list_item1:"+list_item.pop());
//      Log.d("MarkDowanTest","list_item.isEmpty:"+list_item.isEmpty());
        setContentView(R.layout.activity_park_history);
//      Log.d("MarkDowanTest","list_item_length:"+list_item.length());
//      park_number++;
//      Log.d("MarkDowanTest","list_item_number" + park_number);
//      for (int i=0;i<park_number;i++){
//      data[i]="2016年"+5+"月"+(i+1)+"日";
//      time_length[i]=((i+1)%2)+"小时";
//      cost[i]="消费"+(((i+1)%2)*10)+"元";
//      position[i]="山东省威海市纬"+(i+1)+"路某某大街某某家属院";
//      System.out.println("list_item:"+list_item.pop().toString()+list_item.pop());
//      Log.d("MarkDowanTest","list_item_first:"+(String)list_item.pop());
        position[park_number-1] = (String) list_item.pop();
        cost[park_number-1] = (String) list_item.pop();
        time_length[park_number-1] = (String) list_item.pop();
        data[park_number-1] = (String)(list_item.pop());
//      }
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
//      for (int i = 0; i < park_number; i++) {
        Map<String, Object> listItem = new HashMap<String, Object>();
        listItem.put("data", data[park_number-1]);
        listItem.put("time_length", time_length[park_number-1]);
        listItem.put("cost", cost[park_number-1]);
        listItem.put("position", position[park_number-1]);
        listItems.add(listItem);
          //  }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.simple_item_for_park_history,
                new String[]{"data", "time_length", "cost", "position"},
                new int[]{R.id.park_history_data, R.id.park_history_time_length,
                        R.id.park_history_cost, R.id.park_history_position});

        listView = (ListView) findViewById(R.id.park_history_list);
        listView.setAdapter(simpleAdapter);
        list_item.clear();
    }
}