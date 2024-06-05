package com.example.intentexplicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String [] cityArr = {"Hola", "Xavalo", "FUDA", "CanTho"};
            Student student = new Student("Truong Dinh Thanh", "SE160921");
            Bundle bundle = new Bundle();
            bundle.putString("string", "Truyen data voi Bundle");
            bundle.putInt("number", 511);
            bundle.putStringArray("array", cityArr);
            bundle.putSerializable("student", student);

            intent.putExtra("Bundle", bundle);
            startActivity(intent);
        });
    }
}