package com.example.and.tabimg;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost mTabHost = getTabHost();
        //tabs.getTabWidget().setStripEnabled(false);
        //TabHost.TabSpec tabSpec1 = tabs.newTabSpec("");
/*        mTabHost.addTab(mTabHost.newTabSpec("tab_test1")
        .setIndicator("탭1")
        .setContent(R.));
  */  }
}
