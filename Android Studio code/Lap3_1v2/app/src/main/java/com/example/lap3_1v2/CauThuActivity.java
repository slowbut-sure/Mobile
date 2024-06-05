package com.example.lap3_1v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class CauThuActivity extends AppCompatActivity{
    ListView lvLegends;
    List<CauThu> cauthus;

    //int selectedPosition = -1;
    CauThuAdapter cauThuAdapter;
    TextView tvFulllName;
    TextView tvDob;
    ImageView imageView;
    ArrayList<CauThu> arrayCauThu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cauthu);
        mapping();
        cauThuAdapter = new CauThuAdapter(this, R.layout.cauthu_listview, cauthus);
        lvLegends.setAdapter(cauThuAdapter);

        Button btnMain = findViewById(R.id.btnMain);
//        Button buttonAdd = findViewById(R.id.buttonAdd);
//        Button buttonUpdate = findViewById(R.id.buttonUpdate);
//        Button buttonDelete = findViewById(R.id.buttonDelete);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CauThuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        lvLegends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                selectedPosition = position;
//                CauThu selectedCau = arrayCauThu.get(position);
//                tvFulllName.setText(selectedCau.getFullName());
//                tvDob.setText(selectedCau.getDateOfBirthString());
//                imageView.setImageResource(selectedCau.getImageResource());
//                imageView.setImageResource(selectedCau.getCountryFlag());
//            }
//        });

        // Xử lý sự kiện nút "Xóa"
//        buttonDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (selectedPosition != -1) {
//                    arrayCauThu.remove(selectedPosition);
//                    cauThuAdapter.notifyDataSetChanged();
//                    clearFields();
//                } else {
//                    Toast.makeText(CauThuActivity.this, "Vui lòng chọn một cầu thủ để xóa.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        buttonUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int selectedPosition = lvLegends.getCheckedItemPosition();
//                if (selectedPosition != -1) {
//                    // Hiển thị dialog hoặc activity chỉnh sửa thông tin cầu thủ
//                    // Sau khi chỉnh sửa, cập nhật thông tin trong danh sách cauthus
//                    // Sau đó, gọi cauThuAdapter.updateCauThu(selectedPosition, updatedCauThu);
//                }
//            }
//        });
    }
    private void mapping() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        lvLegends = findViewById(R.id.lvLegends);
        cauthus = new ArrayList<>();
        try {
            cauthus.add(new CauThu("Paul Scholes", dateFormat.parse("16-11-1974"), R.drawable.anh, R.drawable.paulscholes));
            cauthus.add(new CauThu("Rooney", dateFormat.parse("24-10-1985"), R.drawable.anh, R.drawable.rooney));
            cauthus.add(new CauThu("Pirlo", dateFormat.parse("19-05-1979"), R.drawable.y, R.drawable.pirlo));
            cauthus.add(new CauThu("Toni Kroos", dateFormat.parse("4-01-1990"), R.drawable.duc, R.drawable.kroos));
            cauthus.add(new CauThu("Paul Pogba", dateFormat.parse("15-3-1993"), R.drawable.phap, R.drawable.pogba));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

//    public void removeCauThu(int position) {
//        cauthus.remove(position);
//        notify(); // Cập nhật ListView sau khi xóa
//    }
//    public void updateCauThu(int position, CauThu updatedCauThu) {
//        cauthus.set(position, updatedCauThu);
//        notify(); // Cập nhật ListView sau khi cập nhật
//    }
//
//    private void clearFields() {
//        tvFulllName.setText("");
//        tvDob.setText("");
//        imageView.setImageResource(R.drawable.rooney); // Hình mặc định, bạn có thể thay đổi
//        selectedPosition = -1;
//    }
}

