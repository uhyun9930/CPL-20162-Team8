package com.example.vrlab.smartfarm;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;

public class Soil extends AppCompatActivity {
    Typeface mFont;
    static int count=0;
    LineChart mLineChart;
    soilGraph s;
    TextView TextView_empty;
    String Date_Info;

    boolean today_check;
    int select_year;
    int select_month;
    int select_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil);

        mLineChart = (LineChart)findViewById(R.id.soilchart);
        TextView_empty = (TextView)findViewById(R.id.TextView_soilempty);

        s = new soilGraph(mLineChart, TextView_empty);
        s.Graph(Menu.nowDate);
        today_check = true;
}

    public void onFindSoilDate(View v){
        DatePickerDialog dialog;
        if(today_check)
        {
            dialog = new DatePickerDialog(Soil.this,android.R.style.Theme_Holo_Dialog,listener,Integer.parseInt(Menu.year), Integer.parseInt(Menu.month)-1, Integer.parseInt(Menu.day));
            today_check = false;
        }
        else
        {
            dialog = new DatePickerDialog(Soil.this,android.R.style.Theme_Holo_Dialog,listener,select_year, select_month, select_day);
        }
        dialog.show();
        TextView empty = (TextView)findViewById(R.id.text_soil);
        empty.setText("");
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            select_year = year;
            select_month = month;
            select_day = dayOfMonth;
            month +=1;
            Date_Info = year + "-" + month + "-" + dayOfMonth;
            update();
            Toast.makeText(Soil.this, year + "년 " + month + "월 " + dayOfMonth +"일으로 설정하셨습니다", Toast.LENGTH_SHORT).show();
            // 년 월 일값 설정 받는 곳
        }
    };
    public void onRightSoil(View v){
        count++;
        if(count==1) {
            TextView RightText = (TextView) findViewById(R.id.text_soil);
            String nowSoil = Menu.infoList.get(Menu.infoList.size()-1).get("soil_humid");
            float nowSoil_float = Float.parseFloat(nowSoil);
            String txt = "현재 토양 습도 " + nowSoil +"%\n우리 농장의 적정 토양 습도는 \n60~80% 입니다";
            RightText.setTextColor(Color.BLACK);
            RightText.setTextSize(20);
            String output="";
            String nowtemp = "";
            String temp = "";
            String rest = "";

            if(nowSoil_float > 80)
            {
                nowtemp = "적정 토양 습도보다 ( ";
                temp = String.valueOf(nowSoil_float - 80);
                rest = " )% 높습니다.";
            }
            else if(nowSoil_float < 60)
            {
                nowtemp = "적정 토양 습도보다 ( ";
                temp = String.valueOf(60- nowSoil_float);
                rest = " )% 낮습니다.";
            }
            else
            {
                nowtemp = "적정 토양 습도를 유지하고 있습니다.";
            }
            output = nowtemp + temp + rest; // temp값만 변경하면 됩니다.
            String result = txt + "\n\n" + output;
            RightText.setText(result);
            txt=output=nowtemp=rest=temp="";
        }
        count=0;
    }

    public void update() {
        s = null;
        s= new soilGraph(mLineChart, TextView_empty);
        s.Graph(Date_Info);
    }
}
