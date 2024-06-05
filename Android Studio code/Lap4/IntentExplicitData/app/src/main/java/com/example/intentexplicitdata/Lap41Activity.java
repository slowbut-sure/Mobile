package com.example.intentexplicitdata;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class Lap41Activity extends AppCompatActivity {
    private static String orderedFood = null;
    private static String orderedDrink = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lap4_1);

        Button btnOrderFood = findViewById(R.id.btnOrderFood);
        Button btnOrderDrink = findViewById(R.id.btnOrderDrink);
        Button btnQuit = findViewById(R.id.btnQuit);
        TextView tvOrderedFood = findViewById(R.id.tvOrderedFood);
        TextView tvOrderedDrink = findViewById(R.id.tvOrderedDrink);

        String newOrderedFood = getIntent().getStringExtra("orderedFood");
        String newOrderedDrink = getIntent().getStringExtra("orderedDrink");

        if (newOrderedFood != null) {
            orderedFood = newOrderedFood;
        }
        if (orderedFood != null) {
            tvOrderedFood.setText("Món ăn đã chọn: " + orderedFood);
        } else {
            tvOrderedFood.setText("Món ăn đã chọn: Chưa có");
        }

        if (newOrderedDrink != null) {
            orderedDrink = newOrderedDrink;
        }
        if (orderedDrink != null) {
            tvOrderedDrink.setText("Đồ uống đã chọn: " + orderedDrink);
        } else {
            tvOrderedDrink.setText("Đồ uống đã chọn: Chưa có");
        }

        btnOrderFood.setOnClickListener(v -> {
            Intent intent = new Intent(Lap41Activity.this, ThucAnActivity.class);
            startActivity(intent);
        });

        btnOrderDrink.setOnClickListener(v -> {
            Intent intent = new Intent(Lap41Activity.this, DoUongActivity.class);
            startActivity(intent);
        });

        btnQuit.setOnClickListener(v -> {
            new AlertDialog.Builder(Lap41Activity.this)
                    .setTitle("Thoát")
                    .setMessage("Bạn có chắc chắn muốn thoát ứng dụng?")
                    .setPositiveButton("Thoát", (d, w) -> {
                        finishAffinity();
                        System.exit(0);
                    })
                    .setNegativeButton("Huỷ", null)
                    .show();
        });
    }
}
