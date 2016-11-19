package com.example.vrlab.smartfarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Camera extends AppCompatActivity {

    TextView Temp;
    TextView Moi;
    TextView Soil;
    TextView Light;
    TextView Date_Info;

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mWebView = (WebView)findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://155.230.158.166:8080/html/");
        mWebView.setWebViewClient(new WebViewClientClass());

        Temp = (TextView)findViewById(R.id.TextView_camera_temp);
        Moi = (TextView)findViewById(R.id.TextView_camera_moi);
        Soil = (TextView)findViewById(R.id.TextView_camera_soil);
        Light = (TextView)findViewById(R.id.TextView_camera_light);
        Date_Info = (TextView)findViewById(R.id.TextView_camera_date_info);

        Temp.setText(Menu.infoList.get(Menu.infoList.size()-1).get("temperature")+"도");
        Moi.setText(Menu.infoList.get(Menu.infoList.size()-1).get("humid")+"%");
        Soil.setText(Menu.infoList.get(Menu.infoList.size()-1).get("soil_humid")+"%");
        Light.setText(Menu.infoList.get(Menu.infoList.size()-1).get("illumination")+"LUX");
        String date[];
        String time[];

        date = Menu.infoList.get(Menu.infoList.size()-1).get("date_info").split("-");
        time = Menu.infoList.get(Menu.infoList.size()-1).get("time_info").split("-");
        Date_Info.setText(date[0]+"년 "+date[1]+"월 "+ date[2]+"일 " + time[0] + "시");
    }
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
