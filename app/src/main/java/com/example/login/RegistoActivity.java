package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistoActivity extends AppCompatActivity {

    EditText edt_username;
    EditText edt_password;
    Button btn_registar;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registo);

        edt_username = findViewById(R.id.edt_registo_name);
        edt_password = findViewById(R.id.edt_registo_password);
        btn_registar = findViewById(R.id.btn_registar);

        btn_registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();

                if(username.equals("") || password.equals("")){
                    Toast.makeText(RegistoActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                }else{
                    i = getIntent();
                    i.putExtra("password", password);
                    i.putExtra("username", username);
                    setResult(1, i);
                    finish();
                }
            }
        });
    }
}