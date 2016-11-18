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

public class Temp extends AppCompatActivity {
    Typeface mFont;
    static int count=0;
    LineChart mLineChart;
    tempGraph t;
    String Date_Info;
    TextView TextView_empty;

    boolean today_check;
    int select_year;
    int select_month;
    int select_day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        TextView_empty = (TextView)findViewById(R.id.TextView_tempempty);
        mLineChart = (LineChart)findViewById(R.id.tempchart);
        t= new tempGraph(mLineChart, TextView_empty);
        t.Graph(Menu.nowDate);
        today_check = true;
        // TextView RightText = (TextView)findViewById(R.id.RightText);
    }
    public void onFindDate(View v){
        DatePickerDialog dialog;
        if(today_check)
        {
            dialog = new DatePickerDialog(Temp.this,android.R.style.Theme_Holo_Dialog,listener,
                    Integer.parseInt(Menu.year), Integer.parseInt(Menu.month)-1, Integer.parseInt(Menu.day));
            today_check = false;
        }
        else
        {
            dialog = new DatePickerDialog(Temp.this,android.R.style.Theme_Holo_Dialog,listener,
                    select_year, select_month, select_day);
        }
        dialog.show();
        TextView empty = (TextView)findViewById(R.id.text);
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
            Toast.makeText(Temp.this, year + "년 " + month + "월 " + dayOfMonth +"일으로 설정하셨습니다", Toast.LENGTH_SHORT).show();
            // 년 월 일값 설정 받는 곳
        }
    };
    public void onRightTemp(View v){
        count++;
        if(count==1) {
            TextView RightText = (TextView) findViewById(R.id.text);
            String nowTemp = Menu.infoList.get(Menu.infoList.size()-1).get("temperature");
            float nowTemp_float = Float.parseFloat(nowTemp);
            String txt = "현재온도 "+nowTemp+"도\n우리 농장의 적정 온도는 15~25도 입니다";
            RightText.setTextColor(Color.BLACK);
            RightText.setTextSize(20);
            String output;
            String nowtemp = "";
            String temp = "";
            String rest = "";
            if(nowTemp_float > 25)
            {
                nowtemp = "적정 온도보다 ( ";
                temp = String.valueOf(nowTemp_float - 25);
                rest = " )도 높습니다.";
            }
            else if(nowTemp_float < 15)
            {
                nowtemp = "적정 온도보다 ( ";
                temp = String.valueOf(15-nowTemp_float);
                rest = " )도 낮습니다.";
            }
            else
            {
                nowtemp = "적정 온도를 유지하고 있습니다.";
            }
            output = nowtemp + temp  + rest; // temp값만 변경하면 됩니다.
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
        t = null;
        t= new tempGraph(mLineChart, TextView_empty);
        t.Graph(Date_Info);
    }
}
