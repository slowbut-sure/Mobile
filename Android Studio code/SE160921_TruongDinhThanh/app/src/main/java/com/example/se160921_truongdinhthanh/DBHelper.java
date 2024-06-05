package com.example.se160921_truongdinhthanh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context) {
        super(context, "SE160921_NET1602", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "Create table author(aId INTEGER PRIMARY KEY AUTOINCREMENT, aName TEXT, aAdress TEXT, aPhone TEXT)";
        try {
            sqLiteDatabase.execSQL(sql);
        } catch (Exception e) {
            Log.d("Error create database: ", e.getMessage());
        }
        sql = "CREATE TABLE book(bid INTEGER PRIMARY KEY AUTOINCREMENT,bname TEXT,bdate TEXT,type TEXT, authorId INTEGER, FOREIGN KEY (authorId) REFERENCES author(aId))";
        try {
            sqLiteDatabase.execSQL(sql);
        } catch (Exception e) {
            Log.d("Error create database: ", e.getMessage());
        }
        sql = "INSERT INTO author (aName, aAdress, aPhone) VALUES ('TacGia1', 'HCM', '0123456789')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO author (aName, aAdress, aPhone) VALUES ('TacGia2', 'Ha noi', '0123456788')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO author (aName, aAdress, aPhone) VALUES ('TacGia3', 'Da Nang', '0123456787')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO author (aName, aAdress, aPhone) VALUES ('TacGia4', 'Can Tho', '0123456786')";
        sqLiteDatabase.execSQL(sql);

        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach1', '1/1/2021', 'Action', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach2', '2/2/2022','Action', 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach3', '3/3/2023','Romance', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach4', '4/4/2024','Romance', 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach5', '5/5/2025','Manhua', 3)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach6', '6/6/2026','Manhua', 3)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach7', '7/7/2027','Manwha', 4)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO book (bname, bdate, type, authorId) VALUES ('Sach8', '8/8/2028','Manwha', 4)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if exists author");
        sqLiteDatabase.execSQL("Drop Table if exists book");
        onCreate(sqLiteDatabase);
    }
}
