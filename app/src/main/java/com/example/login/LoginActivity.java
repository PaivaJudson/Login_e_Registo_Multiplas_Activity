package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button btn_logar;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.edt_login_user);
        password = findViewById(R.id.edt_login_password);
        btn_logar = findViewById(R.id.btn_login);

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strUsername = username.getText().toString();
                String  strPassword = password.getText().toString();

                i = getIntent();
                String intentPassword = i.getExtras().getString("senha");
                String intentUser = i.getExtras().getString("usuario");

                if(strUsername.equals(intentUser) && strPassword.equals(intentPassword)){
                    i = new Intent(LoginActivity.this, SobreActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Login Incorrecto", Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                }
            }
        });
    }
}