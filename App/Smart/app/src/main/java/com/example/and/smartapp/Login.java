package com.example.and.smartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button join = (Button)findViewById(R.id.join);
    }
    public void onJoin(View v){
        Intent intent = new Intent(Login.this,Join.class);
        startActivity(intent);
    }
    public void onLogin(View v){
        Intent i = new Intent(Login.this,Menu.class);
        startActivity(i);
    }
}
