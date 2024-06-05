package com.example.ex1;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    // Views
    private EditText etUsername;
    private EditText etPassword;
    private Button buttonSignIn;
    private TextView tvNotAccountYet;
    // Notify
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Reference from layout
        etUsername = findViewById(R.id.editTextText);
        etPassword = findViewById(R.id.editTextTextPassword);
        tvNotAccountYet = findViewById(R.id.textViewCreate);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        // Register event
        tvNotAccountYet.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
    }

    private boolean checkInput() {
        // UserName
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }

        // Password
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }

        // Valid
        return true;
    }

    public void signIn() {
        // Invalid
        if (!checkInput()) {
            return;
        }

        // Start MainActivity
        Intent intent = new Intent(this,EX3Activity.class);
        intent.putExtra("username", etUsername.getText().toString());
        startActivity(intent);
        finish(); //Close current activity
    }

    public void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSignIn) {
            signIn();
        } else if (v.getId() == R.id.textViewCreate) {
            signUpForm();
        }
    }
}
