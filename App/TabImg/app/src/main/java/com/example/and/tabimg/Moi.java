package com.example.and.tabimg;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class Moi extends AppCompatActivity {
    Typeface mFont;
    static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moi);
    }

    public void onFindMoiDate(View v){
        DatePickerDialog dialog = new DatePickerDialog(Moi.this,android.R.style.Theme_Holo_Dialog,listener,2016,11,16);
        dialog.show();
        TextView empty = (TextView)findViewById(R.id.text_moi);
        empty.setText("");
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Toast.makeText(Moi.this, year + "년" + month + "월" + dayOfMonth +"일으로 설정하셨습니다", Toast.LENGTH_SHORT).show();
            // 년 월 일값 설정 받는 곳
        }
    };
    public void onRightMoi(View v){
        count++;
        if(count==1) {
            TextView RightText = (TextView) findViewById(R.id.text_moi);
            String txt = "우리 농장의 적정 습도는 60~80% 입니다";
            RightText.setTextColor(Color.BLACK);
            RightText.setTextSize(20);
            String output;
            String nowtemp = "현재 습도와 (";
            String temp = " ";
            String rest = ")% 차입니다.";
            output = nowtemp + temp + rest; // temp값만 변경하면 됩니다.
            String result = txt + "\n\n" + output;
            //  RightText.setText(result);
            final SpannableStringBuilder sp = new SpannableStringBuilder(result);
            sp.setSpan(new ForegroundColorSpan(Color.RED), 14, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sp.setSpan(new AbsoluteSizeSpan(80), 14, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sp.setSpan(new ForegroundColorSpan(Color.RED), 33, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            sp.setSpan(new AbsoluteSizeSpan(80), 33, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            RightText.append(sp);
            txt=output=nowtemp=rest=temp="";
        }

        count=0;
    }
}
