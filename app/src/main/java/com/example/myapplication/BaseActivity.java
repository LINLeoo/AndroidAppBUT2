package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class BaseActivity extends AppCompatActivity {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";
    public boolean isValid(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public boolean isValidEmail(String email) {
        return isValid(email, EMAIL_REGEX);
    }

    public boolean isValidPassword(String password) {
        return isValid(password, PASSWORD_REGEX);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
    }

    protected void setupBackButton() {
        ImageButton btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}
