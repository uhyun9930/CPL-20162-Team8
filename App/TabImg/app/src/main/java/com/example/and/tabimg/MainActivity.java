package com.example.and.tabimg;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        TabHost mTab = getTabHost();
        TabHost.TabSpec spec;

        LayoutInflater.from(this).inflate(R.layout.activity_main
        ,mTab.getTabContentView(),true);

       // spec = mTab.newTabSpec("tab1").setIndicator("First Tab")
         spec = mTab.newTabSpec("tab1")
                 //.setIndicator("",getResources().getDrawable(R.drawable.temp))
                .setIndicator("")
                 .setContent(R.id.tv1);
        mTab.addTab(spec);
        spec = mTab.newTabSpec("tab2").setIndicator("")
                .setContent(R.id.tv2);
        mTab.addTab(spec);
        spec = mTab.newTabSpec("tab3").setIndicator("")
                .setContent(R.id.tv3);
        mTab.addTab(spec);
        spec = mTab.newTabSpec("tab4").setIndicator("")
                .setContent(R.id.tv4);
        mTab.addTab(spec);
        for(int i = 0; i < mTab.getTabWidget().getChildCount(); i++) {
            switch(i){   // 각 탭에 자신의 이미지를 추가 한다.
                case 0 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.temp));
                    break;
                case 1 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.moi));
                    break;
                case 2 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.light));
                    break;
                case 3 :
                    mTab.getTabWidget().getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.soil));
                    break;
            }
        }
    }

}
