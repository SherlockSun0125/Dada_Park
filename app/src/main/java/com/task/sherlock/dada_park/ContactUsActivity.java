package com.task.sherlock.dada_park;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

public class ContactUsActivity extends AppCompatActivity {

//    QuickContactBadge badge;
   Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
//        badge= (QuickContactBadge) findViewById(R.id.badge);
//        badge.assignContactFromPhone("0371-62295891",false);
        button= (Button) findViewById(R.id.contact_us);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //"android.intent.action.CALL"
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:10086"));
             //   startActivity(intent);
            }
        });
    }
}
