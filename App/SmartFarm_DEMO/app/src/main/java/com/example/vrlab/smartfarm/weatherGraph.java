package com.example.vrlab.smartfarm;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class weatherGraph {
    LineChart mLineChart;
    ArrayList<ShortWeather> shortWeathers;

    public weatherGraph(LineChart mLineChart, ArrayList<ShortWeather> shortWeathers)
    {
        this.mLineChart = mLineChart;
        this.shortWeathers = shortWeathers;
    }

    public void tempGraph()
    {
        List<Entry> valsComp1 = new ArrayList<Entry>();
        for(int i = 0; i<shortWeathers.size(); i++)
        {
            Entry e=new Entry(i, Float.parseFloat(shortWeathers.get(i).getTemp()));
            valsComp1.add(e);
        }

        LineDataSet setComp1 = new LineDataSet(valsComp1, "온도");
        setComp1.setCircleColor(Color.BLACK);
        setComp1.setColor(Color.BLACK);
        setComp1.setValueTextSize(18);
        setComp1.setLineWidth(2);
        setComp1.setCircleRadius(4);
        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>(); //ㅣine 그리기
        dataSets.add(setComp1);

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                String day="";
                switch (shortWeathers.get((int)value).getDay())
                {
                    case "0":
                        day = "오늘";
                        break;
                    case "1":
                        day = "내일";
                        break;
                    case "2":
                        day = "모레";
                        break;
                }
                return day+"\n"+shortWeathers.get((int)value).getHour()+"시";
            }

            // we don't draw numbers, so no decimal digits needed
            @Override
            public int getDecimalDigits() {  return 0; }
        };

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setTextSize(12);
        xAxis.setEnabled(true);

        YAxis yLAxis = mLineChart.getAxisLeft();
        yLAxis.setEnabled(false);
        YAxis yRAxis = mLineChart.getAxisRight();
        yRAxis.setEnabled(false);

        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        mLineChart.setTouchEnabled(true);
        Description description =new Description();
        description.setText("");
        mLineChart.setDescription(description);
        // mLineChart.setHorizontalScrollBarEnabled(true);
        Legend legend = mLineChart.getLegend(); // label
        legend.setEnabled(false);
        mLineChart.setVisibleXRangeMaximum(4);
        mLineChart.invalidate(); // refresh
    }
}
