package com.example.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtNumber;
    Button btnRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = (TextView) findViewById(R.id.textView);
        btnRandom = (Button) findViewById(R.id.button);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tao so ngau nhien
                Random random = new Random();
                int number = random.nextInt( 10);
                txtNumber.setText(number + "");
                txtNumber.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        });
    }
}