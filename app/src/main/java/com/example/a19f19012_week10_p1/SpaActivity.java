package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SpaActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button confirmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);

        radioGroup = findViewById(R.id.radio_group_spa);
        confirmbtn = (Button) findViewById(R.id.rbspa4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbspa1:
                        Toast.makeText(SpaActivity.this, "Back massage has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbspa2:
                        Toast.makeText(SpaActivity.this, "Neck, Head, Shoulder massage has been selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbspa3:
                        Toast.makeText(SpaActivity.this, "Full Body massage has been selected", Toast.LENGTH_SHORT).show();
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