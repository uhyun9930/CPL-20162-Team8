package com.example.vrlab.smartfarm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
//155.230.86.111
//10.10.10.179
public class Menu extends AppCompatActivity {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PID = "pid";
    private static final String TAG_PNAME = "pname";
    private static final String TAG_DATE = "date";
    private static final String TAG_TEMPERATURE = "temperature";
    private static final String TAG_SOIL_HUMID = "soil_humid";
    private static final String TAG_HUMID = "humid";
    private static final String TAG_ILLUMINATION = "illumination";
    private static final String TAG_TIME_INFO = "time_info";
    private static final String TAG_DATE_INFO = "date_info";


    JSONArray farms = null;
    JSONArray info = null;
    static ArrayList<HashMap<String, String>> farmList; // email pid pname date 정보
    static ArrayList<HashMap<String, String>> infoList; // plant_info

    static String pid;

    static String year;
    static String month;
    static String day;

    static String nowDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String temp[];
        String Time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        temp = Time.split("/");
        year = temp[0];
        month = temp[1];
        temp = temp[2].split(" ");
        day = temp[0];
        nowDate= year + "-" + month+ "-" + day;

        // DB 데이터 받기
        infoList = new ArrayList<HashMap<String, String>>();
        farmList = new ArrayList<HashMap<String, String>>();
        String email=Login.email;
        getFarmData(email);
        pid="1"; // 식물선택
        getInfoData(pid);
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

    public void getFarmData(final String email) {
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String email = params[0];
                InputStream inputStream = null;
                String result = null;
                try {
                    String link = "http://155.230.86.83/smartfarm/farm_info.php?email="+email;
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet request = new HttpGet();
                    request.setURI(new URI(link));
                    HttpResponse response = httpclient.execute(request);
                    HttpEntity entity = response.getEntity();
                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                } finally {
                    try {
                        if (inputStream != null) inputStream.close();
                    } catch (Exception squish) {
                    }
                }
                return result;
            }
            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                makeFarmList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(email);
    }

    protected void makeFarmList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            farms = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < farms.length(); i++) {
                JSONObject c = farms.getJSONObject(i);
                String email = c.getString(TAG_EMAIL);
                String pid = c.getString(TAG_PID);
                String pname=c.getString(TAG_PNAME);
                String date=c.getString(TAG_DATE);
                HashMap<String, String> farms = new HashMap<String, String>();

                farms.put(TAG_EMAIL, email);
                farms.put(TAG_PID, pid);
                farms.put(TAG_PNAME, pname);
                farms.put(TAG_DATE, date);
                farmList.add(i, farms);
                //farmList.add(farms);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void getInfoData(final String pid) {
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String pid = params[0];

                InputStream inputStream = null;
                String result = null;
                try {
                    String link = "http://155.230.86.83/smartfarm/plant_info.php?pid="+pid;
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet request = new HttpGet();
                    request.setURI(new URI(link));
                    HttpResponse response = httpclient.execute(request);
                    HttpEntity entity = response.getEntity();
                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops
                } finally {
                    try {
                        if (inputStream != null) inputStream.close();
                    } catch (Exception squish) {
                    }
                }
                return result;
            }
            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                makeInfoList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(pid);
    }

    protected void makeInfoList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            info = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < info.length(); i++) {
                JSONObject c = info.getJSONObject(i);
                String pid = c.getString(TAG_PID);
                String date_info = c.getString(TAG_DATE_INFO);
                String time_info = c.getString(TAG_TIME_INFO);
                String temperature = c.getString(TAG_TEMPERATURE);
                String illumination = c.getString(TAG_ILLUMINATION);
                String humid = c.getString(TAG_HUMID);
                String soil_humid = c.getString(TAG_SOIL_HUMID);

                HashMap<String, String> info = new HashMap<String, String>();

                info.put(TAG_PID, pid);
                info.put(TAG_DATE_INFO, date_info);
                info.put(TAG_TIME_INFO, time_info);
                info.put(TAG_TEMPERATURE, temperature);
                info.put(TAG_ILLUMINATION, illumination);
                info.put(TAG_HUMID, humid);
                info.put(TAG_SOIL_HUMID, soil_humid);

                infoList.add(info);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
