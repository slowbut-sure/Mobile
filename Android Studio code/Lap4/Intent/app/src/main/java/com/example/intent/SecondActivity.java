package com.example.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends Activity {
    Button btnSecond;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA","onStart Second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA","onRestart Second");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA","onResume Second");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA","onPause Second");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA","onStop Second");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA","onDestroy Second");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = (Button) findViewById(R.id.button1);
        btnSecond.setOnClickListener((view)->{
            Intent intent = new Intent(SecondActivity.this, MainActivity.class );
            startActivity(intent);
        });
    }
}
