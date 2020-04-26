package com.darani.urconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Button temp,dist,time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp=findViewById(R.id.temp);
        dist=findViewById(R.id.dist);
        time=findViewById(R.id.time);

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,TempActivity.class);
                startActivity(i);
            }
        });

        dist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DistanceActivity.class);
                startActivity(i);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, TimeActivity.class);
                startActivity(i);
            }
        });


    }
}
