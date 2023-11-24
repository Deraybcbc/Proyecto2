package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginboton, vercontra;

    private boolean visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BUSCAR IDS
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginboton = (Button) findViewById(R.id.loginboton);
        vercontra = (Button) findViewById(R.id.verContra);


        //LOGIN USUARIO
        loginboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Toast.makeText(MainActivity.this, R.string.LoginExito, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.LoginFallo, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //PARA VER CONTRASEÑA
        vercontra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(visible){
                    password.setInputType(129);
                    visible = false;
                    vercontra.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.baseline_key_24,0);

                }else{
                    password.setInputType(128);
                    visible = true;
                    vercontra.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.baseline_key_off_24, 0);
                }


            }
        });



    }
}