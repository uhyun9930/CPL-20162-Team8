package com.example.vrlab.smartfarm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class NoticeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_menu);
    }
    public void onProfile(View v){
        Intent i = new Intent(NoticeMenu.this,Profile.class);
        startActivity(i);
    }
    public void onCalendar(View v){
        Intent i = new Intent(NoticeMenu.this,Calendar.class);
        startActivity(i);
    }
    public void onNotice(View v){
        Intent i = new Intent(NoticeMenu.this,Notice.class);
        startActivity(i);
    }
    public void onLogout(View v){
        new AlertDialog.Builder(NoticeMenu.this)
                .setTitle("로그아웃")
                .setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("로그아웃",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //메인으로
                                Intent intent = new Intent(getApplicationContext(), Login.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                Login.email = "";
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }
}
