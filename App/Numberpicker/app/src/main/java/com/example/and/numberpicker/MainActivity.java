package com.example.and.numberpicker;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
/*
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberPicker picker1 = (NumberPicker)findViewById(R.id.numberpicker);
        picker1.setMaxValue(10);
        picker1.setMinValue(0);
        picker1.setWrapSelectorWheel(false);

    Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            }
        });

    }
}*/
import android.app.Activity;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }


        public void show(){
            final Dialog npDialog = new Dialog(MainActivity.this);
            npDialog.setTitle("NumberPicker Example");
            npDialog.setContentView(R.layout.picker_layout);
            Button setBtn = (Button)npDialog.findViewById(R.id.setBtn);
            Button cnlBtn = (Button)npDialog.findViewById(R.id.CancelButton_NumberPicker);

            final NumberPicker numberPicker = (NumberPicker)npDialog.findViewById(R.id.numberPicker);
            numberPicker.setMaxValue(10);
            numberPicker.setMinValue(0);
            numberPicker.setWrapSelectorWheel(false);
            numberPicker.setOnValueChangedListener(new OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    // TODO Auto-generated method stub
                }
            });

            setBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub

                    Toast.makeText(MainActivity.this, "Number selected: " + numberPicker.getValue() , Toast.LENGTH_SHORT).show();

                    npDialog.dismiss();
                }
            });

            cnlBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    npDialog.dismiss();
                }
            });

            npDialog.show();
        }
    }


