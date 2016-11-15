package com.example.and.smartapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NoticeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_menu);
    }
    public void onPro(View v){
        Intent i = new Intent(NoticeMenu.this,Profile.class);
        startActivity(i);
    }
    public void onSch(View v){
        Intent j = new Intent(NoticeMenu.this,Schedule.class);
        startActivity(j);

    }
    public void onNot(View v){
        Intent k = new Intent(NoticeMenu.this,Notice.class);
        startActivity(k);
    }
}
