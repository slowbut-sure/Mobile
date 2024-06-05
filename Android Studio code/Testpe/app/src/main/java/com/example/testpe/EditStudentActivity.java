package com.example.testpe;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class EditStudentActivity extends Activity{
    private EditText nameEditText, dateEditText, genderEditText, addressEditText, idNganhEditText;
    private Button updateButton;
    private DatabaseHelper databaseHelper;
    private long studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        nameEditText = findViewById(R.id.nameEditText);
        dateEditText = findViewById(R.id.dateEditText);
        genderEditText = findViewById(R.id.genderEditText);
        addressEditText = findViewById(R.id.addressEditText);
        idNganhEditText = findViewById(R.id.idNganhEditText);
        updateButton = findViewById(R.id.updateButton);

        databaseHelper = new DatabaseHelper(this);

        // Nhận dữ liệu Sinh viên cần chỉnh sửa từ Intent hoặc truy vấn
        studentId = getIntent().getLongExtra("student_id", -1);

        if (studentId != -1) {
            loadStudentData();
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStudentInDatabase();
            }
        });
    }

    private void loadStudentData() {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();

        String[] projection = {
                DatabaseHelper.COLUMN_NAME,
                DatabaseHelper.COLUMN_DATE,
                DatabaseHelper.COLUMN_GENDER,
                DatabaseHelper.COLUMN_ADDRESS,
                DatabaseHelper.COLUMN_IDNGANH
        };

        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(studentId)};

        Cursor cursor = database.query(
                DatabaseHelper.TABLE_SINHVIEN,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            nameEditText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)));
            dateEditText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATE)));
            genderEditText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_GENDER)));
            addressEditText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ADDRESS)));
            idNganhEditText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_IDNGANH)));
        }

        cursor.close();
    }

    private void updateStudentInDatabase() {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, nameEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_DATE, dateEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_GENDER, genderEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_ADDRESS, addressEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_IDNGANH, Integer.parseInt(idNganhEditText.getText().toString()));

        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(studentId)};

        int rowsUpdated = database.update(DatabaseHelper.TABLE_SINHVIEN, values, selection, selectionArgs);

        if (rowsUpdated > 0) {
            // Cập nhật thành công
            // Thực hiện các thao tác bạn muốn sau khi cập nhật Sinh viên
            finish();
        } else {
            // Cập nhật thất bại
            // Xử lý lỗi hoặc thông báo cho người dùng
        }
    }
}
