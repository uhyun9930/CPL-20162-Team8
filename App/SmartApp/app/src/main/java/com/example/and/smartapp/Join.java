package com.example.and.smartapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Join extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        Button BackLogin = (Button)findViewById(R.id.BackLogin);
    }
    public void BackLogin(View v){
        Intent intent = new Intent(Join.this,Login.class);
        startActivity(intent);
    }
}
