package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {
    EditText adminName, adminPass;
    Button adminConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminName = (EditText) findViewById(R.id.AdminNamebtn);
        adminPass = (EditText) findViewById(R.id.AdminPasswordbtn);
        adminConfirm = (Button) findViewById(R.id.AdminConfirmbtn);

        adminConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = adminName.getText().toString();
                String pass = adminPass.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(AdminLoginActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();}
                else{

                    if(user.equals("Admin") && pass.equals("000")){
                        Toast.makeText(AdminLoginActivity.this, "Signed in as Admin", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), AdminPageActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(AdminLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}