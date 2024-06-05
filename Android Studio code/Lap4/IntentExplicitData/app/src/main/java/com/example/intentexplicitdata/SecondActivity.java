package com.example.intentexplicitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button btnLap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnLap = findViewById(R.id.btnLap4);
        btnLap.setOnClickListener((view)->{
            Intent intent = new Intent(SecondActivity.this, Lap41Activity.class );
            startActivity(intent);
        });

        TextView tvDisplay = findViewById(R.id.tvDisplay);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        if (bundle != null) {
            String str = bundle.getString("string");
            int number = bundle.getInt("number");
            String[] cityArr = bundle.getStringArray("array");
            StringBuilder arrString = new StringBuilder();
            for (int i = 0; i < cityArr.length; i++) {
                if (i == cityArr.length - 1)
                    arrString.append(cityArr[i]);
                else arrString.append(cityArr[i]).append(", ");
            }
            Student student = (Student) bundle.getSerializable("student");
            String result = "String: " + str + "\n" + "Number: " + number + "\n" + "Array: " + arrString + "\n" + "Student: " + student.getName() + " - " + student.getId();

            tvDisplay.setText(result);
        }

    }
}
