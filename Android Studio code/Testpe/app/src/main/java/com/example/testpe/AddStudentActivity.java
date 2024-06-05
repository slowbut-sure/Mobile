package com.example.testpe;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class AddStudentActivity extends Activity{
    private EditText nameEditText, dateEditText, genderEditText, addressEditText, idNganhEditText;
    private Button addButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        nameEditText = findViewById(R.id.nameEditText);
        dateEditText = findViewById(R.id.dateEditText);
        genderEditText = findViewById(R.id.genderEditText);
        addressEditText = findViewById(R.id.addressEditText);
        idNganhEditText = findViewById(R.id.idNganhEditText);
        addButton = findViewById(R.id.addButton);

        databaseHelper = new DatabaseHelper(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentToDatabase();
            }
        });
    }

    private void addStudentToDatabase() {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, nameEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_DATE, dateEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_GENDER, genderEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_ADDRESS, addressEditText.getText().toString());
        values.put(DatabaseHelper.COLUMN_IDNGANH, Integer.parseInt(idNganhEditText.getText().toString()));

        long newRowId = database.insert(DatabaseHelper.TABLE_SINHVIEN, null, values);

        if (newRowId != -1) {
            // Thêm thành công
            // Thực hiện các thao tác bạn muốn sau khi thêm Sinh viên
            finish();
        } else {
            // Thêm thất bại
            // Xử lý lỗi hoặc thông báo cho người dùng
        }
    }
}
