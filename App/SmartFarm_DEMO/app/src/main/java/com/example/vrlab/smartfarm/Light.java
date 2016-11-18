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

public class Light extends AppCompatActivity {
    Typeface mFont;
    static int count=0;
    LineChart mLineChart;
    String Date_Info;
    TextView TextView_empty;
    boolean today_check;
    int select_year;
    int select_month;
    int select_day;

    lightGraph l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        mLineChart = (LineChart)findViewById(R.id.lightchart);
        TextView_empty = (TextView)findViewById(R.id.TextView_lightempty);
        l = new lightGraph(mLineChart, TextView_empty);
        l.Graph(Menu.nowDate);
        today_check = true;
    }

    public void onFindLigDate(View v){
        DatePickerDialog dialog;
        if(today_check) {
            dialog = new DatePickerDialog(Light.this, android.R.style.Theme_Holo_Dialog, listener, Integer.parseInt(Menu.year), Integer.parseInt(Menu.month) - 1, Integer.parseInt(Menu.day));
            today_check = false;
        }else {
            dialog = new DatePickerDialog(Light.this, android.R.style.Theme_Holo_Dialog, listener,select_year, select_month, select_day);
        }
        dialog.show();
        TextView empty = (TextView)findViewById(R.id.text_lig);
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
            Toast.makeText(Light.this, year + "년 " + month + "월 " + dayOfMonth +"일으로 설정하셨습니다", Toast.LENGTH_SHORT).show();
            // 년 월 일값 설정 받는 곳
        }
    };
    public void onRightLig(View v){
        count++;
        if(count==1) {
            TextView RightText = (TextView) findViewById(R.id.text_lig);
            String nowLight = Menu.infoList.get(Menu.infoList.size()-1).get("illumination");
            float nowLight_float = Float.parseFloat(nowLight);
            String txt = "현재조도 "+ nowLight + "Lux\n우리 농장의 적정 조도는 \n2만 5000 ~ 3만 Lux 입니다";
            RightText.setTextColor(Color.BLACK);
            RightText.setTextSize(20);
            String output="";
            String nowtemp="";
            String rest="";
            String temp="";
            if(nowLight_float > 30000)
            {
                nowtemp= "적정 조도보다 ( ";
                temp = String.valueOf(nowLight_float-30000);
                rest = " )Lux 높습니다.";
            }

            else if(nowLight_float < 25000)
            {
                nowtemp= "적정 조도보다 ( ";
                temp = String.valueOf(25000 - nowLight_float);
                rest = " )Lux 낮습니다.";
            }
            else
            {
                nowtemp="적정 조도를 유지하고 있습니다.";
            }
            output = nowtemp + temp + rest; // temp값만 변경하면 됩니다.
            String result = txt + "\n\n" + output;
            RightText.setText(result);

            txt=output=nowtemp=rest=temp="";
        }
        // final SpannableStringBuilder sp1 =
        //        new SpannableStringBuilder(rest);
        // sp1.setSpan(new ForegroundColorSpan(Color.RED),7,10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //RightText.setText(txt);
        // RightText.append(sp1);

        count=0;
    }
    public void update() {
        l = null;
        l= new lightGraph(mLineChart, TextView_empty);
        l.Graph(Date_Info);
    }
}
