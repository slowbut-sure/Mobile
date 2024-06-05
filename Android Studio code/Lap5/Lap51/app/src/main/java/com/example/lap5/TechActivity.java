package com.example.lap5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class TechActivity extends AppCompatActivity {
    List<Tech> techs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);

        RecyclerView rvPhoneList = findViewById(R.id.rvTechList);

        techs = new ArrayList<>();
        techs.add(new Tech("Asus Rog Flow", "Asus", 2020, 100, R.drawable.asusrogflowx16));
        techs.add(new Tech("Asus Rog Strix", "Asus", 2021, 200, R.drawable.asusrogstrixscar18));
        techs.add(new Tech("Asus Rog Zephyrus", "Asus", 2022, 300, R.drawable.asusrogzephyrusduo16));
        techs.add(new Tech("Acer Predator", "Acer", 2023, 400, R.drawable.acerpredatorhelios18));
        techs.add(new Tech("Msi Titan", "MSI", 2024, 500, R.drawable.msititangt77hx));

        rvPhoneList.setAdapter(new TechAdapter(techs));
        rvPhoneList.setLayoutManager(new LinearLayoutManager(this));
    }
}