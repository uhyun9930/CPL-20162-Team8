package com.example.and.smartapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

  //  private ListView mListview = null;
    //String[] menu = {"그래프","카메라","날씨","관리"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       /* ListView listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> arrName = new ArrayList<String>();
        arrName.add("그래프");
        arrName.add("카메라");
        arrName.add("날씨");
        arrName.add("관리");
        ArrayAdapter<String> adapName = new ArrayAdapter<String>(
                this,
                R.layout.item,
                R.id.name,
                arrName
        );
        listView.setAdapter(adapName);*/
    }
    public void onWeather(View v)
    {
        Intent i = new Intent(Menu.this, Weather.class);
        startActivity(i);
    }
    public void onGraph(View v){
        Intent i = new Intent(Menu.this,Graph.class);
        startActivity(i);
    }
    public void onCamera(View v){
        Intent in = new Intent(Menu.this,Camera.class);
        startActivity(in);
    }
    public void onSetting(View v){
        Intent j = new Intent(Menu.this,NoticeMenu.class);
        startActivity(j);
    }

}
