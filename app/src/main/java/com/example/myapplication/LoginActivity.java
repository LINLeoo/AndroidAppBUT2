package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupBackButton();

        Button btnRegister = findViewById(R.id.btnCreateAccount);
        btnRegister.setOnClickListener(v -> openRegister());

        Button btnHabitat = findViewById(R.id.btnHabitat);
        btnHabitat.setOnClickListener(v -> openHabitat());


        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPassword = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> {
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (!isValidEmail(email))
                editEmail.setError("Email invalide");
            else if (!isValidPassword(password))
                editPassword.setError("Mot de passe invalide");
            else
                Toast.makeText(this, "Connexion réussie ✅", Toast.LENGTH_SHORT).show();

        });
    }
    private void openRegister(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void openHabitat(){
        Intent intent = new Intent(LoginActivity.this, HabitatActivity.class);
        startActivity(intent);
    }

}