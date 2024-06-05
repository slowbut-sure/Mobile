package com.example.testpe;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class StudentListActivity extends Activity {
    private ListView listView;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        listView = findViewById(R.id.listView);

        // Khởi tạo DatabaseHelper và thực hiện truy vấn
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getReadableDatabase();

        // Thực hiện truy vấn để lấy danh sách Sinh viên
        Cursor cursor = database.query(DatabaseHelper.TABLE_SINHVIEN,
                new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME},
                null, null, null, null, null);

        // Tạo một SimpleCursorAdapter để hiển thị dữ liệu lên ListView
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursor,
                new String[]{DatabaseHelper.COLUMN_NAME},
                new int[]{android.R.id.text1}, 0);

        listView.setAdapter(adapter);

        // Trong một phần của ứng dụng Android, bạn cần thêm mã sau để thêm Sinh viên mới vào cơ sở dữ liệu SQLite.

        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, "John Doe");
        values.put(DatabaseHelper.COLUMN_DATE, "2000-01-01");
        values.put(DatabaseHelper.COLUMN_GENDER, "Male");
        values.put(DatabaseHelper.COLUMN_ADDRESS, "123 Main St");
        values.put(DatabaseHelper.COLUMN_IDNGANH, 1); // ID của Chuyên ngành
        long newRowId = database.insert(DatabaseHelper.TABLE_SINHVIEN, null, values);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Đóng cơ sở dữ liệu khi không cần sử dụng nữa
        database.close();
    }
}
