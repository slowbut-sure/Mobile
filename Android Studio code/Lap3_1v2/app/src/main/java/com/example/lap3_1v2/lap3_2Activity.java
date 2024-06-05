package com.example.lap3_1v2;

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

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class lap3_2Activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_lap3_2);
        AnhXa();
        adapter = new TraiCayAdapter(this, R.layout.trai_cay, arrayTraiCay);
        lvTraicay.setAdapter(adapter);

        // Sao chép ảnh từ thư mục drawable vào thư mục tạm thời
        int imageResourceId = getResources().getIdentifier("nho", "drawable", getPackageName());

        if (imageResourceId != 0) {
            InputStream inputStream = getResources().openRawResource(imageResourceId);
            File tempDir = new File(getCacheDir(), "temp_images");
            if (!tempDir.exists()) {
                tempDir.mkdirs();
            }

            File tempFile = new File(tempDir, "temp_image.jpg");
            try {
                OutputStream outputStream = new FileOutputStream(tempFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //===========================================================================================

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
                int hinh = R.drawable.ic_launcher_background; // Hình mặc định, bạn có thể thay đổi
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
                    Toast.makeText(lap3_2Activity.this, "Vui lòng chọn một trái cây để cập nhật.", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(lap3_2Activity.this, "Vui lòng chọn một trái cây để xóa.", Toast.LENGTH_SHORT).show();
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
