package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DBhelper DB;
    EditText t1, t2, t3, t4;
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        t1 = (EditText) findViewById(R.id.First_name_reg);
        t2 = (EditText) findViewById(R.id.Last_name_reg);
        t3 = (EditText) findViewById(R.id.Pass_reg);
        b1 = (Button) findViewById(R.id.Create_btn_reg);
        b2 = (Button) findViewById(R.id.cancel_btn_reg);
        t4 = (EditText) findViewById(R.id.email_reg);
        DB = new DBhelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = t1.getText().toString();
                String last_name = t2.getText().toString();
                String password = t3.getText().toString();
                String email = t4.getText().toString();
                if (first_name.equals("") || last_name.equals("") || password.equals("") || email.equals("")){
                    Toast.makeText(Register.this, "inserer tous les cases", Toast.LENGTH_LONG).show();
                }else{
                    Boolean check = DB.insert_client(first_name, last_name, password, email);
                if (check == true){
                    Toast.makeText(Register.this, "inserted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(Register.this, "not inserted", Toast.LENGTH_LONG).show();
                }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}