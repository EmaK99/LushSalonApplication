package com.example.a19f19012_week10_p1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.material.internal.NavigationMenu;

import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "customer.db";
    public static final String TABLE_NAME = "CUSTOMER";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "( NAME TEXT primary key, PASSWORD TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, pass);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Boolean updatepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PASSWORD", password);
        long result = db.update(TABLE_NAME, contentValues, "NAME = ?", new String[] {username});
        if (result == -1)
            return false;
        else
            return true;
    }
    public Boolean deletedata(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from CUSTOMER where NAME = ?", new String[] {name});
        if (cursor.getCount() > 0){
            long result = db.delete("customer", "NAME = ?", new String[] {name});
            if (result == -1)
            { return false;}
            else
            {return true;}
        }else{
            return false;
        }
    }
    public Cursor getdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from CUSTOMER", null);
        return cursor;
    }
    public Boolean checkname(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from CUSTOMER where NAME = ?", new String[] {name});
        if (cursor.getCount() >0)
            return true;
        else
            return false;
    }
    public Boolean checknamepassword(String name, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from CUSTOMER where NAME =? and PASSWORD =?", new String[] {name, pass});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}