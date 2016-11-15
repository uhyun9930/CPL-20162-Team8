package com.example.and.tabimg;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Moi extends AppCompatActivity {
    Typeface mFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moi);
        TextView RightText = (TextView)findViewById(R.id.RightText);
        mFont = Typeface.createFromAsset(getAssets(),"NanumBarunGothic.ttf");
        RightText.setTypeface(mFont);
    }
}
