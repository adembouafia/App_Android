package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView UsrListView;
    ArrayList <String> first_name, last_name, email;
    DBhelper DB;
    UserListAdapter adpt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        DB = new DBhelper(this);
        first_name = new ArrayList<>();
        last_name = new ArrayList<>();
        email = new ArrayList<>();
        UsrListView = findViewById(R.id.usrlist);
        adpt = new UserListAdapter(this, first_name, last_name, email);
        UsrListView.setAdapter(adpt);
        UsrListView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.user();
        if (cursor.getCount()==0){
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                first_name.add(cursor.getString(1));
                last_name.add(cursor.getString(2));
                email.add(cursor.getString(4));
            }
        }
    }
}