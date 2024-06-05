package com.example.projectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //khai bao bien
    TextView txtNoidung;
    Button btnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh xa
        txtNoidung = (TextView) findViewById(R.id.textViewNoidung);
        btnClick = (Button) findViewById(R.id.button1);

        //code
        //txtNoidung.setText("Lap trinh Android");

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNoidung.setText("Lap trinh Android");
            }
        });


    }
}