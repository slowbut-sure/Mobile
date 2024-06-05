package com.example.lap1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInsta = findViewById(R.id.btnInsta);
        btnInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để chuyển từ MainActivity sang InstagramActivity
                Intent intent = new Intent(MainActivity.this, InstagramActivity.class);
                startActivity(intent);
            }
        });

    }
}