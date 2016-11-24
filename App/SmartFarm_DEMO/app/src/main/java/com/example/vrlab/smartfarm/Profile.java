package com.example.vrlab.smartfarm;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//155.230.86.83

public class Profile extends AppCompatActivity {
    static  long now = System.currentTimeMillis();
    static final Date dateInit = new Date(now);
    static final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
    static final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
    static final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);
    static int YEAR = Integer.parseInt(curYearFormat.format(dateInit));
    static int Month = Integer.parseInt(curMonthFormat.format(dateInit));
    static int date = Integer.parseInt(curDayFormat.format(dateInit));


    private RecyclerView horizontal_farmInfo_view;
    private ArrayList<farm_Item> horizontalList;
    private Profile.HorizontalAdapter horizontalAdapter;
    private LinearLayoutManager horizontalLayoutManagaer;
    TextView Text_ID;
    TextView Text_DATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Text_ID = (TextView)findViewById(R.id.id);
        Text_ID.setText(Login.email);
        Text_DATE = (TextView)findViewById(R.id.date);
        Text_DATE.setText(Menu.farmList.get(0).get("date"));

        horizontal_farmInfo_view = (RecyclerView) findViewById(R.id.horizontal_farmInfo_view);

        horizontalList = new ArrayList<>();

        for(int i=0; i<Menu.farmList.size(); i++) {
            horizontalList.add(new farm_Item(Menu.farmList.get(i).get("pid"), Menu.farmList.get(i).get("pname")));
        }
        horizontalAdapter = new Profile.HorizontalAdapter(horizontalList);

        horizontalLayoutManagaer = new LinearLayoutManager(Profile.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_farmInfo_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_farmInfo_view.setAdapter(horizontalAdapter);

    }
    public void onInsert(View v){
        String year = String.valueOf(YEAR);
        String month = String.valueOf(Month);
        String date_ = String.valueOf(date);
        String today = year+"년 "+month+"월 "+date_+"일";
        final String _today = year+"-"+month+"-"+date_;
        final EditText plant_name = new EditText(getApplicationContext());
        plant_name.setTextColor(Color.WHITE);

        new AlertDialog.Builder(Profile.this)
                .setTitle("오늘 날짜는 "+today)
                .setMessage("식물 이름을 입력해주세요")
                .setView(plant_name)
                //insert에 email 추가해주세요
                .setPositiveButton("입력",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String pname = plant_name.getText().toString();

                                addPlant(pname, _today);
                                addFarm(Login.email);
                                new Menu().getFarmData(Login.email);
                            }
                        }).setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
    }

    public void onDelete(View v){
        final EditText plant_id = new EditText(getApplicationContext());
        plant_id.setTextColor(Color.WHITE);
        new AlertDialog.Builder(Profile.this)
                .setTitle("농장 식물 삭제")
                .setMessage("식물 번호을 입력해주세요")
                .setView(plant_id)
                //insert에 email 추가해주세요
                .setPositiveButton("삭제",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str_pid = plant_id.getText().toString();
                                deletePlant(str_pid);
                            }
                        }).setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
    }

    private void addPlant(final String pname, String date) {

        class addPlantAsync extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(String... params) {
                String pname = params[0];
                String date = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("pname", pname));
                nameValuePairs.add(new BasicNameValuePair("date", date));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://155.230.86.83/smartfarm/addPlant.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                     HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                if(s.equalsIgnoreCase("success")){
                    }else {
                }
            }
        }
        addPlantAsync la = new addPlantAsync();
        la.execute(pname, date);
    }

    private void addFarm(final String email) {

        class addFarmAsync extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(String... params) {
                String email = params[0];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("email", email));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://155.230.86.83/smartfarm/addFarm.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                if(s.equalsIgnoreCase("success")){

                }else {
                }
            }
        }
        addFarmAsync la = new addFarmAsync();
        la.execute(email);
    }

    private void deletePlant(final String pname) {

        class deletePlantAsync extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(String... params) {
                String pname = params[0];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("pname", pname));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://155.230.86.83/smartfarm/deletePlant.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                if(s.equalsIgnoreCase("success")){
                }else {
                }
            }
        }
        deletePlantAsync la = new deletePlantAsync();
        la.execute(pname);
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<Profile.HorizontalAdapter.MyViewHolder> {

        private List<farm_Item> horizontalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView pid;
            public TextView pname;

            public MyViewHolder(View view) {
                super(view);
                pid = (TextView)view.findViewById(R.id.TextView_pid);
                pname = (TextView)view.findViewById(R.id.TextView_pname);
            }
        }

        public HorizontalAdapter(List<farm_Item> horizontalList) {
            this.horizontalList = horizontalList;
        }

        @Override
        public Profile.HorizontalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);

            return new Profile.HorizontalAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final Profile.HorizontalAdapter.MyViewHolder holder, final int position) {
            holder.pid.setText(horizontalList.get(position).getPid());
            holder.pname.setText(horizontalList.get(position).getPname());
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }
}
