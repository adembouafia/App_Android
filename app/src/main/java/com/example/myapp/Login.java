package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText t1, t2;
    Button B1, B2;
    TextView v1;
    DBhelper DB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1 = (EditText) findViewById(R.id.email_lgn);
        t2 = (EditText) findViewById(R.id.Password_lgn);
        B1 = (Button) findViewById(R.id.login_btn);
        B2 = (Button) findViewById(R.id.cancel_btn);
        v1 = (TextView) findViewById(R.id.text_cree);
        DB = new DBhelper(this);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = t1.getText().toString();
                String password = t2.getText().toString();
                if (email.equals("") || password.equals("")) {
                    Toast.makeText(Login.this, "vide", Toast.LENGTH_LONG).show();
                }else{
                    Boolean check = DB.check_user(email, password);
                    if (check == true){
                        Toast.makeText(Login.this, "Login successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login.this, HomePage.class);
                        startActivity(intent);
                    } else{
                        Toast.makeText(Login.this, "User not found", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}