package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BeautyActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button confirmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);

        radioGroup = findViewById(R.id.radio_group_beauty);
        confirmbtn = (Button) findViewById(R.id.rbbeau5);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbbeau1:
                        Toast.makeText(BeautyActivity.this, "Manicure has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbbeau2:
                        Toast.makeText(BeautyActivity.this, "Pedicure has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbbeau3:
                        Toast.makeText(BeautyActivity.this, "Paraffin Manicure has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbbeau4:
                        Toast.makeText(BeautyActivity.this, "Spa Pedicure has been selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
            }
        });
    }
}