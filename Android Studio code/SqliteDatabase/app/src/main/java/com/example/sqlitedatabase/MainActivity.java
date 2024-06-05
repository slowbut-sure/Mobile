package com.example.sqlitedatabase;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lvCongViec;
    ArrayList <CongViec> arrayCongViec;
    CongViecAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec =(ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec = new ArrayList<>();
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        lvCongViec.setAdapter(adapter);

        //Tao database GhiChu
        database = new Database(this, "Ghi chu.sqlLite", null, 1);

        //tao database CongViec
        database.QueryData("Create table if not exists Cong Viec(id Integer Primary Key Autoincrement," +
                "TenCV nvarchar(200))");

        //InsertData
         database.QueryData("Insert into CongViec value(null, 'Project Android')");
         database.QueryData("Insert into CongViec value(null, 'Design App')");

        //Select Data
        Cursor dataCongViec = database.getData("Select * from CongViec");
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
//            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id, ten));
        }
        adapter.notifyDataSetChanged();
    }
}