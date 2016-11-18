package com.example.vrlab.smartfarm;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Notice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
    }
    public void onTempNotice(View v){
        show();
    }
    public void show(){
        final Dialog npDialog = new Dialog(Notice.this);
        npDialog.setTitle("NumberPicker Example");
        npDialog.setContentView(R.layout.picker_layout);
        Button setBtn = (Button)npDialog.findViewById(R.id.setBtn);
        Button cnlBtn = (Button)npDialog.findViewById(R.id.CancelButton_NumberPicker);
        final NumberPicker numberPicker = (NumberPicker)npDialog.findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(0);
        numberPicker.setValue(5);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub
            }
        });
        setBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(Notice.this, "Number selected: " + numberPicker.getValue() , Toast.LENGTH_SHORT).show();
                npDialog.dismiss();
            }
        });
        cnlBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                npDialog.dismiss();
            }
        });

        npDialog.show();
    }
    public void onMoiNotice(View v){
        show();
    }

    public void onLigNotice(View v){
        show();
    }

    public void onSoilNotice(View v){
        show();
    }
}
