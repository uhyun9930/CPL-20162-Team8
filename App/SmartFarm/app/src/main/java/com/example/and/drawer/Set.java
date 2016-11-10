package com.example.and.drawer;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Set extends Fragment {


    public Set() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set, container, false);
        Button first = (Button)view.findViewById(R.id.setfirst);
        Button second = (Button)view.findViewById(R.id.setsecond);
        Button third = (Button)view.findViewById(R.id.setthird);
        Button setup = (Button)view.findViewById(R.id.setup);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(getActivity(),listener1,07,00,true);
                dialog.show();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog2 = new TimePickerDialog(getActivity(),listener2,12,00,true);
                dialog2.show();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog3 = new TimePickerDialog(getActivity(),listener3,5,00,true);
                dialog3.show();
            }
        });
        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"변경완료되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
       return view;
        // return inflater.inflate(R.layout.fragment_set, container, false);
    }
    private TimePickerDialog.OnTimeSetListener listener1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(getActivity(),"아침식사입력시간 알림을 \n" + hourOfDay+"시"+minute+"분으로 설정하셨습니다.",Toast.LENGTH_SHORT).show();
        }
    };
    private TimePickerDialog.OnTimeSetListener listener2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(getActivity(),"점심식사입력시간 알림을 \n" + hourOfDay+"시"+minute+"분으로 설정하셨습니다.",Toast.LENGTH_SHORT).show();
        }
    };
    private TimePickerDialog.OnTimeSetListener listener3 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(getActivity(),"저녁식사입력시간 알림을 \n" + hourOfDay+"시"+minute+"분으로 설정하셨습니다.",Toast.LENGTH_SHORT).show();
        }
    };
}
