package com.example.and.manage;

import android.content.Intent;
import android.icu.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onProfile(View v){
        Intent i = new Intent(MainActivity.this,Profile.class);
        startActivity(i);
    }
    public void onCalendar(View v){
        Intent i = new Intent(MainActivity.this,Calendar.class);
        startActivity(i);
    }
    public void onNotice(View v){
        Intent i = new Intent(MainActivity.this,Notice.class);
        startActivity(i);
    }
    public void onLogout(View v){
        Intent i = new Intent(MainActivity.this,Logout.class);
        startActivity(i);
    }
}
