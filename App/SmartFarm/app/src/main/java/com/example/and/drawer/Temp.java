package com.example.and.drawer;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

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
public class Temp extends Fragment {


    public Temp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp, container, false);
        LineChart chart = (LineChart)view.findViewById(R.id.chartTemp);
        Button button = (Button)view.findViewById(R.id.buttonTemp);
        ArrayList<Entry> valComp1 = new ArrayList<Entry>();

        valComp1.add(new Entry(20.0f,0));
        valComp1.add(new Entry(20.5f,1));
        valComp1.add(new Entry(22.0f,2));
        valComp1.add(new Entry(20.5f,3));
        valComp1.add(new Entry(18.5f,4));
        valComp1.add(new Entry(18.0f,5));
        valComp1.add(new Entry(16.0f,6));
        valComp1.add(new Entry(15.0f,7));
        valComp1.add(new Entry(15.5f,8));
        valComp1.add(new Entry(14.3f,9));
        valComp1.add(new Entry(13.0f,10));
        valComp1.add(new Entry(15.5f,11));
        valComp1.add(new Entry(16.8f,12));
        valComp1.add(new Entry(15.5f,13));
        valComp1.add(new Entry(13.0f,14));
        valComp1.add(new Entry(14.3f,15));
        valComp1.add(new Entry(15.0f,16));
        valComp1.add(new Entry(16.5f,17));




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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getActivity(),android.R.style.Theme_Holo_Dialog,listener,2016,10,26);
                dialog.show();

            }


        });


        return view;
        //return inflater.inflate(R.layout.fragment_fat, container, false);
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //Toast.makeText(getActivity(), year + "년" + month + "월" + dayOfMonth +"일으로 설정하셨습니다", Toast.LENGTH_SHORT).show();
        }
    };

}

