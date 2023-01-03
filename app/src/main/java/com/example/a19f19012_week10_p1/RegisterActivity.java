package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper mDb;
    EditText name, pass, repass;
    TextView forgot, delete;
    Button signup, signin, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mDb = new DatabaseHelper(this);
        //get the IDs of editext
        name = (EditText) findViewById(R.id.typename);
        pass = (EditText) findViewById(R.id.typepass);
        repass = (EditText) findViewById(R.id.typerepass);

        forgot = (TextView) findViewById(R.id.forgotbtn);
        delete = (TextView) findViewById(R.id.deletebtn);
        clear = (Button) findViewById(R.id.clearbtn);

        //get the ids of button
        signup = (Button) findViewById(R.id.submitbtn1);
        signin = (Button) findViewById(R.id.submitbtn2);

        clearData();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String pw = pass.getText().toString();
                String repw= repass.getText().toString();

                if(user.equals("")||pw.equals("")||repw.equals(""))
                    Toast.makeText(RegisterActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                else{
                    if(pw.equals(repw)){
                        Boolean checkuser=mDb.checkname(user);
                        if(checkuser==false){
                            Boolean insert = mDb.insertData(user,pw);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "User already exists. Please sign-in.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
                startActivity(intent);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DeleteAccActivity.class);
                startActivity(intent);
            }
        });

    }
    //clear the screen
    public void clearData()
    {
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                name.setText("");
                pass.setText("");
                repass.setText("");
            }
        });
    }

}
