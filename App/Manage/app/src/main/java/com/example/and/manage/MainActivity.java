package com.example.and.manage;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.*;
import android.support.v7.app.AlertDialog;
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
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("로그아웃")
                .setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("로그아웃",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //메인으로
                            }
                        })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}
