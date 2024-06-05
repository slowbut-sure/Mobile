package com.example.testpe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_SINHVIEN = "Sinhvien";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_IDNGANH = "idNganh";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_SINHVIEN + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_IDNGANH + " INTEGER" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng Sinhvien
        String createTableSinhvien = "CREATE TABLE " + TABLE_SINHVIEN + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_IDNGANH + " INTEGER" +
                ");";
        db.execSQL(createTableSinhvien);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SINHVIEN);
        onCreate(db);
    }
}
