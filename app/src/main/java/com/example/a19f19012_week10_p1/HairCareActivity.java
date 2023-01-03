package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HairCareActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button confirmbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_care);

        radioGroup = findViewById(R.id.radio_group);
        confirmbtn = (Button) findViewById(R.id.rbhc5);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbhc1:
                        Toast.makeText(HairCareActivity.this, "Haircut has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbhc2:
                        Toast.makeText(HairCareActivity.this, "Root Color has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbhc3:
                        Toast.makeText(HairCareActivity.this, "Keratine has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbhc4:
                        Toast.makeText(HairCareActivity.this, "Hair Spa has been selected", Toast.LENGTH_SHORT).show();
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