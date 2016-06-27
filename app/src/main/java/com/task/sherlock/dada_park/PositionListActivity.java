package com.task.sherlock.dada_park;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionListActivity extends AppCompatActivity {

    private int position_number=18;

    private int[] image=new int[]{
            R.drawable.small_car_position,R.drawable.big_car_position};

    private String[] distance=new String [position_number];
    private String[] position=new String [position_number];
    private String[] price=new String[position_number];
    private int[] positionIds=new int[position_number];

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position__list);

        for (int i=0;i<position_number;i++){
            distance[i]="距离"+(i+1)+"公里";
            position[i]="山东省威海市纬"+(i+5)+"路";
            price[i]=10*i+"/小时";
            positionIds[i]=image[i%2];
        }

        List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
        for (int i=0; i<position_number;i++){
            Map<String,Object> listItem= new HashMap<String,Object>();
            listItem.put("image",positionIds[i]);
            listItem.put("distance",distance[i]);
            listItem.put("price",price[i]);
            listItem.put("position",position[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,
                R.layout.simple_item_for_position_list,
                new String[]{"image","distance","price","position"},
                new int[]{R.id.position_list_image,R.id.position_list_distance,
                R.id.position_list_price,R.id.position_list_position});

        ListView listView= (ListView) findViewById(R.id.position_list_view);
        listView.setAdapter(simpleAdapter);
        //ActionBar
        actionBar=getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
