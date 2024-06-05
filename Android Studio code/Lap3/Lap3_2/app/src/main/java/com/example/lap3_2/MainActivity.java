package com.example.lap3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraicay;
    ArrayList<trai_cay> arrayTraiCay; //dong du lieu gom hinh, ten, mota
    TraiCayAdapter adapter;
    int selectedPosition = -1; // Vị trí trái cây được chọn
    Button buttonThem;
    Button buttonCapNhat;
    Button buttonXoa;
    Button buttonTaiAnh;
    EditText etTen;
    EditText etMota;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter = new TraiCayAdapter(this, R.layout.trai_cay, arrayTraiCay);
        lvTraicay.setAdapter(adapter);

        // Xử lý sự kiện click trên danh sách trái cây
        lvTraicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                trai_cay selectedFruit = arrayTraiCay.get(position);
                etTen.setText(selectedFruit.getTen());
                etMota.setText(selectedFruit.getMota());
                imageView.setImageResource(selectedFruit.qetHinh());
            }
        });

        // Xử lý sự kiện nút "Thêm"
        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTen.getText().toString();
                String mota = etMota.getText().toString();
                int hinh = R.drawable.nho; // Hình mặc định, bạn có thể thay đổi
                trai_cay newFruit = new trai_cay(ten, mota, hinh);
                arrayTraiCay.add(newFruit);
                adapter.notifyDataSetChanged();
                clearFields();
            }
        });

        // Xử lý sự kiện nút "Cập nhật"
        buttonCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    trai_cay selectedFruit = arrayTraiCay.get(selectedPosition);
                    String ten = etTen.getText().toString();
                    String mota = etMota.getText().toString();
                    selectedFruit.setTen(ten);
                    selectedFruit.setMota(mota);
                    adapter.notifyDataSetChanged();
                    clearFields();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một trái cây để cập nhật.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện nút "Xóa"
        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    arrayTraiCay.remove(selectedPosition);
                    adapter.notifyDataSetChanged();
                    clearFields();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một trái cây để xóa.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện nút "Tải ảnh lên"
        buttonTaiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở hộp thoại chọn ảnh
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
    }
    // Xử lý kết quả sau khi chọn ảnh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Xóa nội dung của EditText và đặt selectedPosition về -1
    private void clearFields() {
        etTen.setText("");
        etMota.setText("");
        imageView.setImageResource(R.drawable.nho); // Hình mặc định, bạn có thể thay đổi
        selectedPosition = -1;
    }
    public  void AnhXa(){
        lvTraicay =(ListView) findViewById(R.id.lvtraicay);
        arrayTraiCay = new ArrayList<>();
        etTen = (EditText) findViewById(R.id.etTen);
        etMota = (EditText) findViewById(R.id.etMota);
        imageView = (ImageView) findViewById(R.id.imageView);
        buttonThem = (Button) findViewById(R.id.buttonThem);
        buttonCapNhat = (Button) findViewById(R.id.buttonCapNhat);
        buttonXoa = (Button) findViewById(R.id.buttonXoa);
        buttonTaiAnh = (Button) findViewById(R.id.buttonTaiAnh);

        arrayTraiCay.add(new trai_cay("Chuối", "Chuối xanh Nam Mỹ", R.drawable.chuoi));
        arrayTraiCay.add(new trai_cay("Dâu", "Dâu tây Hàn Quốc", R.drawable.dau));
        arrayTraiCay.add(new trai_cay("Lê", "Lê xanh Bắc Mỹ", R.drawable.le));
        arrayTraiCay.add(new trai_cay("Nho", "Nho nhập Canada", R.drawable.nho1));
        arrayTraiCay.add(new trai_cay("Táo", "Táo đỏ Châu Đại Dương", R.drawable.tao));

    }
}