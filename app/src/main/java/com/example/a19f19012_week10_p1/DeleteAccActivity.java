package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAccActivity extends AppCompatActivity {

    EditText username, password;
    Button delete;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_acc);

        username = (EditText) findViewById(R.id.usernamedel);
        password = (EditText) findViewById(R.id.passworddel);
        delete = (Button) findViewById(R.id.btndel);
        DB = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                Boolean checkdeletedata = DB.deletedata(user);
                        if(checkdeletedata==true){
                            Toast.makeText(DeleteAccActivity.this, "Account has been deleted", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(DeleteAccActivity.this, "Account has not been deleted", Toast.LENGTH_SHORT).show();
                        }
                    }

        });

    }
}