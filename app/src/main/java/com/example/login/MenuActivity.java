package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btn_registo;
    Button btn_login;
    Button btn_sobre;

    String password = "";
    String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_login = findViewById(R.id.btn_login);
        btn_sobre = findViewById(R.id.btn_sobre);
        btn_registo = findViewById(R.id.btn_registo);

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(user.equals("") || password.equals("")){
                    Toast.makeText(MenuActivity.this, "Registe primeiro o utilizador", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                    intent.putExtra("senha", password);
                    intent.putExtra("usuario", user);
                    startActivity(intent);
                }
            }
        });

        btn_registo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, RegistoActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        btn_sobre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SobreActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1 && data != null){
            user = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            Toast.makeText(MenuActivity.this, "Dados Actualizados", Toast.LENGTH_LONG).show();
        }
    }
}