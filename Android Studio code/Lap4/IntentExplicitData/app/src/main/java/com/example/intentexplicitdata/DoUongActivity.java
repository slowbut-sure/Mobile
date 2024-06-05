package com.example.intentexplicitdata;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DoUongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_uong);

        RadioGroup radioGroup = findViewById(R.id.rgDrink);
        Button btnOrderDrink = findViewById(R.id.btnOrderDrink);

        List<String> drinkList = new ArrayList<>();
        drinkList.add("Coca Cola");
        drinkList.add("Pepsi");
        drinkList.add("Sting");
        drinkList.add("Number1");
        drinkList.add("Trà sữa");
        drinkList.add("Trà đào");
        drinkList.add("Trà dâu");
        drinkList.add("Soda chanh");
        drinkList.add("Soda việt quất");
        drinkList.add("Sữa đậu nành");
        drinkList.add("Tiger");
        drinkList.add("Heineken");

        drinkList.forEach(drink -> {
            RadioButton radioButton = new RadioButton(DoUongActivity.this);
            radioButton.setText(drink);
            radioButton.setPadding(12, 0, 0, 0);
            radioButton.setTextSize(18);
            radioButton.setTextColor(Color.parseColor("#4A4A4A"));
            radioButton.setTextAlignment(RadioButton.TEXT_ALIGNMENT_CENTER);
            radioGroup.addView(radioButton);
        });

        btnOrderDrink.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(DoUongActivity.this, "Bạn chưa chọn đồ uống nào.", Toast.LENGTH_SHORT).show();
                return;
            }
            RadioButton radioButton = findViewById(selectedId);
            String drink = radioButton.getText().toString();
            Intent intent = new Intent(DoUongActivity.this, Lap41Activity.class);
            intent.putExtra("orderedDrink", drink);
            startActivity(intent);
        });
    }
}
