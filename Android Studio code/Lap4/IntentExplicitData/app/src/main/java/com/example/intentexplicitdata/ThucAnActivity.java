package com.example.intentexplicitdata;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThucAnActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuc_an);

        RadioGroup radioGroup = findViewById(R.id.rgFood);
        //ListView listView = findViewById(R.id.lvFood);
        Button btnOrderFood = findViewById(R.id.btnOrderFood);

        List<String> foodList = new ArrayList<>();
        foodList.add("Cơm sườn");
        foodList.add("Cơm chiên thập cẩm");
        foodList.add("Cơm thịt bò xào");
        foodList.add("Mì xào hải sản");
        foodList.add("Mì xào bò");
        foodList.add("Bún Bò Huế");
        foodList.add("Bùn thịt nướng");
        foodList.add("Bánh canh cua");
        foodList.add("Bánh mì");

        foodList.forEach(food -> {
            RadioButton radioButton = new RadioButton(ThucAnActivity.this);
            radioButton.setText(food);
            radioButton.setPadding(12, 0, 0, 0);
            radioButton.setTextSize(18);
            radioButton.setTextColor(Color.parseColor("#4A4A4A"));
            radioButton.setTextAlignment(RadioButton.TEXT_ALIGNMENT_CENTER);
            radioGroup.addView(radioButton);
        });

        btnOrderFood.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(ThucAnActivity.this, "Bạn chưa chọn món ăn nào.", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton radioButton = findViewById(selectedId);
            String food = radioButton.getText().toString();
            Intent intent = new Intent(ThucAnActivity.this, Lap41Activity.class);
            intent.putExtra("orderedFood", food);
            startActivity(intent);
        });
    }
}
