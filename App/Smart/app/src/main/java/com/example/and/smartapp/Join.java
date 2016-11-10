package com.example.and.smartapp;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    public void onEmailClick(View v){
        EditText text = (EditText)findViewById(R.id.Email);
        text.setBackground(getResources().getDrawable(R.drawable.edit));
    }
    public void onPwdClick(View v){
        EditText text = (EditText)findViewById(R.id.Pwd);
        text.setBackground(getResources().getDrawable(R.drawable.edit));
    }
    public void onRePwdClick(View v){
        EditText text = (EditText)findViewById(R.id.RePwd);
        text.setBackground(getResources().getDrawable(R.drawable.edit));
    }
}
