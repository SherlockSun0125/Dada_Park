package com.task.sherlock.dada_park;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MarkDownActivity extends AppCompatActivity {

    private EditText park_date;
    private EditText park_time_length;
    private EditText park_cost_money;
    private EditText park_place;
    private Button park_history_save;
    public Remember_spot_list<String> list_item;
    private int park_number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_down);

        list_item= (Remember_spot_list<String>) getApplicationContext();
        park_date= (EditText) findViewById(R.id.park_date);
        park_time_length= (EditText) findViewById(R.id.park_time_length);
        park_cost_money= (EditText) findViewById(R.id.park_cost_money);
        park_place= (EditText) findViewById(R.id.park_place);
        park_history_save= (Button) findViewById(R.id.park_history_save);

        park_history_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                park_number++;
                list_item.push(park_date.getText().toString());
                list_item.push(park_time_length.getText().toString());
                list_item.push(park_cost_money.getText().toString());
                list_item.push(park_place.getText().toString());
                Intent intent=new Intent(MarkDownActivity.this,ParkHistoryActivity.class);
                intent.putExtra("park_number",park_number);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MarkDowanTest","MarkDownActivity Destory");
    }
}
