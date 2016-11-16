package com.example.and.tabimg;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    static int tempcount=0;
    static int moicount=0;
    static int lightcount=0;
    static int soilcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        TabHost mTab = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        LayoutInflater.from(this).inflate(R.layout.activity_main
        ,mTab.getTabContentView(),true);

       // spec = mTab.newTabSpec("tab1").setIndicator("First Tab")
        intent = new Intent(this,Temp.class);
        spec = mTab.newTabSpec("tab1").setIndicator("").setContent(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        mTab.addTab(spec);

        Intent intent1 = new Intent(this,Moi.class);
        spec = mTab.newTabSpec("tab2").setIndicator("").setContent(intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        mTab.addTab(spec);

        Intent intent2 = new Intent(this,Light.class);
        spec = mTab.newTabSpec("tab3").setIndicator("").setContent(intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        mTab.addTab(spec);

        Intent intent3 = new Intent(this,Soil.class);
        spec = mTab.newTabSpec("tab4").setIndicator("").setContent(intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        mTab.addTab(spec);

        for(int i = 0; i < mTab.getTabWidget().getChildCount(); i++) {
            switch(i){   // 각 탭에 자신의 이미지를 추가 한다.
                case 0 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_tab_click));
                    break;
                case 1 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_moi_click));
                    break;
                case 2 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_light_click));
                    break;
                case 3 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_soil_click));
                    break;
            }
        }
    }

}
