package com.example.vrlab.smartfarm;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

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

/**
 * Created by ASUS TP300L on 2016-11-17.
 */

public class moiGraph {
    LineChart mLineChart;
    String DATE;
    TextView TextView_empty;
    private static final String TAG_HUMID = "humid";
    private static final String TAG_TIME_INFO = "time_info";
    private static final String TAG_DATE_INFO = "date_info";

    public moiGraph(LineChart mLineChart, TextView TextView_empty)
    {
        this.mLineChart = mLineChart;
        this.TextView_empty = TextView_empty;
    }

    public void Graph(String date)
    {

        int i;
        for(i = 0; i<Menu.infoList.size(); i++)
        {
            if(Menu.infoList.get(i).containsValue(date))
            {
                TextView_empty.setVisibility(View.INVISIBLE);
                break;
            }
        }
        if(i==Menu.infoList.size())
        {
            TextView_empty.setVisibility(View.VISIBLE);
            return;
        }
        List<Entry> valsComp1 = new ArrayList<Entry>();
        DATE = date;
        for(i = 0; i<Menu.infoList.size(); i++)
        {
            if(DATE.equals(Menu.infoList.get(i).get(TAG_DATE_INFO)))
                valsComp1.add(new Entry(i, Float.parseFloat(Menu.infoList.get(i).get(TAG_HUMID))));
        }
        LineDataSet setComp1 = new LineDataSet(valsComp1, "습도");
        setComp1.setColor(Color.rgb(51, 128, 255));
        setComp1.setCircleColor(Color.rgb(51, 128, 255));
        setComp1.setValueTextSize(18);
        setComp1.setLineWidth(2);
        setComp1.setCircleRadius(4);
        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>(); //ㅣine 그리기
        dataSets.add(setComp1);

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return Menu.infoList.get((int)value).get(TAG_TIME_INFO);
            }

            // we don't draw numbers, so no decimal digits needed
            @Override
            public int getDecimalDigits() {  return 0; }
        };

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
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
        mLineChart.setVisibleXRangeMaximum(5);
        mLineChart.invalidate(); // refresh
    }


}
