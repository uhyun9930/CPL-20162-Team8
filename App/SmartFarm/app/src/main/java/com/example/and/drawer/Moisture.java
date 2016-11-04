package com.example.and.drawer;


import android.os.Bundle;

import android.view.LayoutInflater;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Moisture extends Fragment {


    public Moisture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_moisture, container, false);
        View view = inflater.inflate(R.layout.fragment_moisture, container, false);
        LineChart chart = (LineChart)view.findViewById(R.id.chartMoisture);
        ArrayList<Entry> valComp1 = new ArrayList<Entry>();

        valComp1.add(new Entry(45.0f,0));
        valComp1.add(new Entry(47.5f,1));
        valComp1.add(new Entry(50.0f,2));
        valComp1.add(new Entry(55.5f,3));
        valComp1.add(new Entry(57.5f,4));
        valComp1.add(new Entry(57.0f,5));
        valComp1.add(new Entry(60.0f,6));
        valComp1.add(new Entry(55.0f,7));
        valComp1.add(new Entry(50.5f,8));
        valComp1.add(new Entry(45.3f,9));
        valComp1.add(new Entry(45.0f,10));
        valComp1.add(new Entry(60.5f,11));
        valComp1.add(new Entry(55.8f,12));
        valComp1.add(new Entry(50.5f,13));
        valComp1.add(new Entry(50.0f,14));
        valComp1.add(new Entry(45.3f,15));
        valComp1.add(new Entry(45.0f,16));
        valComp1.add(new Entry(45.5f,17));




        LineDataSet setComp1 = new LineDataSet(valComp1,"User");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("10.01");
        xVals.add("10.02");
        xVals.add("10.03");
        xVals.add("10.04");
        xVals.add("10.05");
        xVals.add("10.06");
        xVals.add("10.07");
        xVals.add("10.08");
        xVals.add("10.09");
        xVals.add("10.10");
        xVals.add("10.11");
        xVals.add("10.12");
        xVals.add("10.13");
        xVals.add("10.14");
        xVals.add("10.15");
        xVals.add("10.16");
        xVals.add("10.17");
        xVals.add("10.18");

        LineData data = new LineData(xVals,dataSets);

        chart.setData(data);
        chart.invalidate();


        return view;

    }

}
