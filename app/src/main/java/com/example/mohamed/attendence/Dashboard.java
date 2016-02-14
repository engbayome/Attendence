package com.example.mohamed.attendence;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends Activity {

    String Status;
    String Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String username =getIntent().getStringExtra("username");
        TextView usernameview = (TextView)findViewById(R.id.username_dash);
        usernameview.setText(username);

        //get last status and time of it


        //set last status
        TextView status = (TextView) findViewById(R.id.status);
        status.setText(Status);

        //set time of last status
        TextView time = (TextView) findViewById(R.id.time);
        time.setText(Time);

        //buttons
        Button chickin = (Button) findViewById(R.id.btn_check_in);
        Button chickout = (Button) findViewById(R.id.btn_check_out);

        chickin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Check_in= new Intent(getApplicationContext() ,Check_in.class);
                startActivity(Check_in);
            }
        });

        chickout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Check_out= new Intent(getApplicationContext() ,Check_out.class);
                startActivity(Check_out);
            }
        });
    }
}