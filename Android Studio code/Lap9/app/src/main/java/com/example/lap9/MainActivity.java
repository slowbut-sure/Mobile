package com.example.lap9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.lap9.adapter.CongViecAdapter;
import com.example.lap9.database.Database;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;

    ListView lvCongViec;

    ArrayList<CongViec> arrayCongViec;

    CongViecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        lvCongViec = (ListView) findViewById(R.id.listviewCongViec);
        arrayCongViec = new ArrayList<>();
        adapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayCongViec);
        lvCongViec.setAdapter(adapter);


        //Tao database
        database = new Database(this, "QhiChu.sqlite", null, 1);

        // Tạo table
        database.queryData("Create table if not exists CongViec(id Integer Primary Key Autoincrement," + "TenCV NVARCHAR(200))");

        //Select data
//        Cursor dataCongViec = database.getData("Select * from CongViec");
//        while (dataCongViec.moveToNext()) {
//            String ten = dataCongViec.getString(1);
//            //Toast.makeText(this,ten, Toast.LENGTH_SHORT).show();
//
//            int id = dataCongViec.getInt(0);
//            arrayCongViec.add(new CongViec(id, ten));
//        }
//        adapter.notifyDataSetChanged();
        GetDataCongViec();
    }

    // ham add menu them
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.menuAdd){
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_them_cong_viec);
        dialog.show();

        EditText edtTen = (EditText) dialog.findViewById(R.id.edittextTenCV);
        Button btnThem = (Button) dialog.findViewById(R.id.buttonThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonHuy);

        // Bắt sự kiện cho Button Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tencv = edtTen.getText().toString();
                // Kiem tra chuoi rỗng --> Khi người dùng không nhập dữ liệu
                if(tencv.equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc!", Toast.LENGTH_SHORT).show();
                }else {
                    database.queryData("Insert into CongViec values(null, '"+tencv+"')");
                    dialog.dismiss(); // tat hộp thoại sau khi đã thêm xong dữ liệu
                    //Show dữ liệu trên listview
                    GetDataCongViec();
                }
            }
        });

        //Bắt sự kiện cho button Huy
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void GetDataCongViec() {
        //Select data
        Cursor dataCongViec = database.getData("Select * from CongViec");
        // Xóa mảng trước khi add để cập nhật lại dữ liệu mới tránh dư thừa
        arrayCongViec.clear();

        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            Toast.makeText(this,ten, Toast.LENGTH_SHORT).show(); // bai 1
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new CongViec(id,ten));
        }
        adapter.notifyDataSetChanged();
    }

    //hàm cập nhật công việc
    public void DialogSuaCongViec(String ten, int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_sua);

        EditText edtTenCV = (EditText) dialog.findViewById(R.id.edittextTenCV);
        Button btnSua = (Button) dialog.findViewById(R.id.buttonSua);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonHuy);

        edtTenCV.setText(ten);

        //Bắt xự kiện cho button Sửa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = edtTenCV.getText().toString().trim();
                database.queryData("UPDATE CongViec SET TenCV = '"+ tenMoi+"' WHERE id = '"+ id +"'");
                Toast.makeText(MainActivity.this, "Da Cap Nhat", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetDataCongViec();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    //Ham xoa cong viec
    public void DialogXoaCongViec(String tencv, int Id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa công việc " + tencv + "không ?" );
        dialogXoa.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.queryData("DELETE FROM CongViec WHERE Id = '"+Id+"' ");
                Toast.makeText(MainActivity.this, "Da Xoa" + tencv,Toast.LENGTH_SHORT).show();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

}
