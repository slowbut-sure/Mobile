package com.prm392.lab6_ex1;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ColorActivity extends AppCompatActivity {
    Button btnChonMau;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_main);

        manHinh = (ConstraintLayout) findViewById(R.id.constraintLayoutMain);
        btnChonMau = (Button) findViewById(R.id.button_Chonmau);

        registerForContextMenu(btnChonMau);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuDo:
                manHinh.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.menuVang:
                manHinh.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;

            case R.id.menuXanh:
                manHinh.setBackgroundColor(getResources().getColor(R.color.green));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
