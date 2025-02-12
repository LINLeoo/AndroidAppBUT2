package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupBackButton();

        EditText editEmail = findViewById(R.id.editEmail);
        EditText editPassword = findViewById(R.id.editPassword);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(view -> {
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
}