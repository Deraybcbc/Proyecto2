package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private Button loginboton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginboton = (Button) findViewById(R.id.loginboton);

        loginboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user")&&password.getText().toString().equals("1234")){
                    Toast.makeText(MainActivity.this, R.string.LoginExito, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, R.string.LoginFallo, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}