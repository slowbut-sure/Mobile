package com.example.lap5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    List<User> users;

    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        btnNext = findViewById(R.id.btnLap5_2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, TechActivity.class);
                startActivity(intent);
            }
        });


        RecyclerView rvUserList = findViewById(R.id.rvUserList);
        users = new ArrayList<>();
        users.add(new User("thanhtd", "Truong Dinh Thanh", "thanhtdse@gmail.com"));
        users.add(new User("tudva", "Doan Van Anh Tu", "tudva@gmail.com"));
        users.add(new User("tungtp", "Truong Phuoc Tung", "tungtp@gmail.com"));
        users.add(new User("hoangth", "Tran Huy Hoang", "hoangth@gmail.com"));
        users.add(new User("khanghd", "Huynh Duc Khang", "khanghd@gmail.com"));

        UserAdapter userAdapter = new UserAdapter(users);
        rvUserList.setAdapter(userAdapter);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));

    }
}