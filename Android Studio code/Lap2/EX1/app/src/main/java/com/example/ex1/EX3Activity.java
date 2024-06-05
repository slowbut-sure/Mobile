package com.example.ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EX3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        TextView textViewHello = findViewById(R.id.textViewHello);
        textViewHello.setText("Xin Chào, " + getIntent().getStringExtra("username"));

        Button btnCalculate = findViewById(R.id.btn1);
        Button btnRandomNumber = findViewById(R.id.btn2);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EX3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EX3Activity.this, EX2Activity.class);
                startActivity(intent);
            }
        });
    }
}
