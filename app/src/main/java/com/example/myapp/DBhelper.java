package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context, "app.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE client (id_client INTEGER PRIMARY KEY AUTOINCREMENT, first_name_client varchar(50), last_name_client varchar(50), password_client varchar(255), e_mail_client varchar(50) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS client");
    }
    public Boolean insert_client (String first_name, String last_name, String password, String email){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name_client", first_name);
        contentValues.put("last_name_client", last_name);
        contentValues.put("password_client", password);
        contentValues.put("e_mail_client", email);
        long result = DB.insert("client", null, contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean check_user (String mail, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM client WHERE e_mail_client = ? AND password_client = ? ", new String[]{mail, password});
        if (cursor.getCount() == 0){
            return false;
        }else{
            return true;
        }
    }
    public Cursor user (){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM client", null);
        return cursor;
    }
}
