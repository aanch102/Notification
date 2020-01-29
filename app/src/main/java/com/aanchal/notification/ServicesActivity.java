package com.aanchal.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends AppCompatActivity {

    Button btnstart,btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);


        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startMyService();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });
    }

    private void startMyService(){
        startService(new Intent(this,myService.class));

    }
    private  void stopMyService(){
        stopService(new Intent(this,myService.class));
    }
}
