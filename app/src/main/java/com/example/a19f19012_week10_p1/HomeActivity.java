package com.example.a19f19012_week10_p1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    Button hair, beauty, spa;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        hair = (Button) findViewById(R.id.btnhair);
        beauty = (Button) findViewById(R.id.btnbeauty);
        spa = (Button) findViewById(R.id.btnspa);
        DB = new DatabaseHelper(this);

        hair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HairCareActivity.class);
                startActivity(intent);
            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BeautyActivity.class);
                startActivity(intent);
            }
        });

        spa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpaActivity.class);
                startActivity(intent);
            }
        });

    }
}