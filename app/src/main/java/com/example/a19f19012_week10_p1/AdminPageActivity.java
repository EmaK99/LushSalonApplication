package com.example.a19f19012_week10_p1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminPageActivity extends AppCompatActivity {

    TextView adminView;
    DatabaseHelper DB;
    EditText adminDeleteUser;
    Button adminDeletebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        adminView = (TextView) findViewById(R.id.ViewDataBtn);
        DB = new DatabaseHelper(this);
        adminDeleteUser = (EditText) findViewById(R.id.AdminDeledit);
        adminDeletebtn = (Button) findViewById(R.id.AdminDelbtn);

        adminView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(AdminPageActivity.this, "No data exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Username: "+ res.getString(0)+"\n");
                    buffer.append("Password: "+ res.getString(1)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminPageActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User details: ");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        adminDeletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = adminDeleteUser.getText().toString();
                Boolean checkdeletedata = DB.deletedata(user);
                if(checkdeletedata==true){
                    Toast.makeText(AdminPageActivity.this, "User has been deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AdminPageActivity.this, "User has not been deleted", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}