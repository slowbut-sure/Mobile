package com.example.testpe;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
public class DeleteStudentActivity extends Activity{
    private ListView listView;
    private Button deleteButton;
    private DatabaseHelper databaseHelper;
    private long selectedStudentId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        listView = findViewById(R.id.listView);
        deleteButton = findViewById(R.id.deleteButton);
        databaseHelper = new DatabaseHelper(this);

        loadStudentList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedStudentId = id;
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteSelectedStudent();
            }
        });
    }

    private void loadStudentList() {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

        String[] projection = {
                DatabaseHelper.COLUMN_ID,
                DatabaseHelper.COLUMN_NAME
        };

        Cursor cursor = database.query(
                DatabaseHelper.TABLE_SINHVIEN,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            adapter.add(name);
        }

        cursor.close();
    }

    private void deleteSelectedStudent() {
        if (selectedStudentId != -1) {
            SQLiteDatabase database = databaseHelper.getWritableDatabase();

            String selection = DatabaseHelper.COLUMN_ID + " = ?";
            String[] selectionArgs = {String.valueOf(selectedStudentId)};

            int rowsDeleted = database.delete(DatabaseHelper.TABLE_SINHVIEN, selection, selectionArgs);

            if (rowsDeleted > 0) {
                // Xóa thành công
                // Thực hiện các thao tác bạn muốn sau khi xóa Sinh viên
                selectedStudentId = -1;
                loadStudentList(); // Cập nhật danh sách
            } else {
                // Xóa thất bại
                // Xử lý lỗi hoặc thông báo cho người dùng
            }
        }
    }
}
