package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextMin = findViewById(R.id.editTextNumberMin);
        EditText editTextMax = findViewById(R.id.editTextNumberMax);
        Button btnGenerate = findViewById(R.id.btnGenerate);
        Button btnBack = findViewById(R.id.btnEx3);
        TextView textViewResult = findViewById(R.id.textViewResult);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EX3Activity.class);
                startActivity(intent);
            }
        });


        btnGenerate.setOnClickListener(v -> {
            try {
                boolean isValid = true;
                String minStr = editTextMin.getText().toString();
                String maxStr = editTextMax.getText().toString();
                if (minStr.trim().isEmpty()) {
                    editTextMin.setError("Please enter a number");
                    isValid = false;
                }
                if (maxStr.trim().isEmpty()) {
                    editTextMax.setError("Please enter a number");
                    isValid = false;
                }
                if (!isValid) {
                    return;
                }
                int min = Integer.parseInt(minStr);
                int max = Integer.parseInt(maxStr);
                if (min >= max) {
                    Toast.makeText(this, "Max number must be greater than the min one.", Toast.LENGTH_SHORT).show();
                } else {
                    Random random = new Random();
                    int result = random.nextInt(max - min + 1) + min;
                    textViewResult.setText("Result: " + result);
                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}