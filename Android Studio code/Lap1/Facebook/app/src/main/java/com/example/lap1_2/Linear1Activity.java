package com.example.lap1_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Linear1Activity extends AppCompatActivity {
    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout1);

        Button btnLayout2 = findViewById(R.id.btnLayout2);
        btnLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Linear1Activity.this, Linear2Activity.class);
                startActivity(intent);
            }
        });

    }
}
