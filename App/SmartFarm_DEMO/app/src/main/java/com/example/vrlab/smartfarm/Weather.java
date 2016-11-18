package com.example.vrlab.smartfarm;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Weather extends AppCompatActivity {


    private RecyclerView horizontal_recycler_view;
    private ArrayList<Item> horizontalList;
    private HorizontalAdapter horizontalAdapter;

    TextView textView_temperature;
    TextView textView_weather;
    TextView textView_pop;
    TextView textView_r6;

    ImageButton btn_update;
    LineChart mLineChart;

    ArrayList<ShortWeather> shortWeathers = new ArrayList<ShortWeather>(); // 날씨정보 ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        textView_temperature = (TextView)findViewById(R.id.temperature);
        textView_weather = (TextView)findViewById(R.id.weather);
        textView_pop = (TextView)findViewById(R.id.pop);
        textView_r6 = (TextView)findViewById(R.id.r6);
        // btn_update = (ImageButton)findViewById(R.id.imageButton);
        mLineChart = (LineChart)findViewById(R.id.chart);

        new ReceiveShortWeather().execute();
    }
    public class ReceiveShortWeather extends AsyncTask<URL, Integer, Long> {

        protected Long doInBackground(URL... urls) {

            String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2723062000";

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = null;

            try {
                response = client.newCall(request).execute();
                parseXML(response.body().string());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(Long result) {
            horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);

            boolean check = true;
            textView_temperature.setText(shortWeathers.get(0).getTemp()+"˚");
            textView_weather.setText(shortWeathers.get(0).getWfKor());

            Drawable img ;

            switch(shortWeathers.get(0).getWfKor())
            {
                case "맑음":
                    switch(shortWeathers.get(0).getHour())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_1 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_1 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;
                    }
                    break;
                case "구름 조금":
                    switch(shortWeathers.get(0).getHour())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_2);
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_2);
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;
                    }

                    break;
                case "구름 많음":
                    switch(shortWeathers.get(0).getHour())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_3 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_3 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;
                    }

                    break;

                case "흐림":
                    switch(shortWeathers.get(0).getHour())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_4 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);

                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_4 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;
                    }

                    break;

                case "비":
                    switch(shortWeathers.get(0).getHour())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_5 );
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_5);
                        img.setBounds(95, 0, 185, 90);
                        textView_weather.setCompoundDrawables(img, null, null, null);
                        break;
                    }
                    break;
            }

            textView_pop.setText("강우확률 " + shortWeathers.get(0).getPop() +"%");
            textView_r6 .setText("강수량 " + shortWeathers.get(0).getR6() +"mm");
            new weatherGraph(mLineChart, shortWeathers).tempGraph();

            horizontalList = new ArrayList<>();

            for(int i=0; i<shortWeathers.size(); i++) {
                switch (shortWeathers.get(i).getDay())
                {
                    case "0":
                        if(check){
                            horizontalList.add(new Item("오늘", shortWeathers.get(i).getHour(),
                                    shortWeathers.get(i).getWfKor(), shortWeathers.get(i).getPop(), shortWeathers.get(i).getR6(),
                                    shortWeathers.get(i).getReh(), shortWeathers.get(i).getWs(), shortWeathers.get(i).getWdKor()));
                            check = false;
                            }
                        else{
                            horizontalList.add(new Item("", shortWeathers.get(i).getHour(),
                                shortWeathers.get(i).getWfKor(), shortWeathers.get(i).getPop(), shortWeathers.get(i).getR6(),
                                shortWeathers.get(i).getReh(), shortWeathers.get(i).getWs(), shortWeathers.get(i).getWdKor()));
                        }
                        break;
                    case "1":
                        if(check) {
                            horizontalList.add(new Item("", shortWeathers.get(i).getHour(),
                                    shortWeathers.get(i).getWfKor(), shortWeathers.get(i).getPop(), shortWeathers.get(i).getR6(),
                                    shortWeathers.get(i).getReh(), shortWeathers.get(i).getWs(), shortWeathers.get(i).getWdKor()));
                        }
                        else{
                            horizontalList.add(new Item("내일", shortWeathers.get(i).getHour(),
                                    shortWeathers.get(i).getWfKor(), shortWeathers.get(i).getPop(), shortWeathers.get(i).getR6(),
                                    shortWeathers.get(i).getReh(), shortWeathers.get(i).getWs(), shortWeathers.get(i).getWdKor()));
                            check = true;
                        }
                        break;
                    case "2":
                        if(check){
                            horizontalList.add(new Item("모레", shortWeathers.get(i).getHour(),
                                    shortWeathers.get(i).getWfKor(), shortWeathers.get(i).getPop(), shortWeathers.get(i).getR6(),
                                    shortWeathers.get(i).getReh(), shortWeathers.get(i).getWs(), shortWeathers.get(i).getWdKor()));
                            check = false;
                        }
                        else{
                            horizontalList.add(new Item("", shortWeathers.get(i).getHour(),
                                    shortWeathers.get(i).getWfKor(), shortWeathers.get(i).getPop(), shortWeathers.get(i).getR6(),
                                    shortWeathers.get(i).getReh(), shortWeathers.get(i).getWs(), shortWeathers.get(i).getWdKor()));
                        }
                        break;
                }
            }

            horizontalAdapter = new HorizontalAdapter(horizontalList);

            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(Weather.this, LinearLayoutManager.HORIZONTAL, false);
            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

            horizontal_recycler_view.setAdapter(horizontalAdapter);
        }

        void parseXML(String xml) {
            try {
                String tagName = "";
                boolean onHour = false;
                boolean onDay = false;
                boolean onTem = false;
                boolean onTmx = false;
                boolean onTmn = false;
                boolean onWfKor = false;
                boolean onPop = false;
                boolean onWs = false;
                boolean onWdKor = false;
                boolean onReh = false;
                boolean onR6 = false;
                boolean onS6 = false;
                boolean onEnd = false;
                boolean isItemTag1 = false;
                int i = 0;

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = factory.newPullParser();

                parser.setInput(new StringReader(xml));

                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        tagName = parser.getName();
                        if (tagName.equals("data")) {
                            shortWeathers.add(new ShortWeather());
                            onEnd = false;
                            isItemTag1 = true;
                        }
                    } else if (eventType == XmlPullParser.TEXT && isItemTag1) {
                        if (tagName.equals("hour") && !onHour) {
                            shortWeathers.get(i).setHour(parser.getText());
                            onHour = true;
                        }
                        if (tagName.equals("day") && !onDay) {
                            shortWeathers.get(i).setDay(parser.getText());
                            onDay = true;
                        }
                        if (tagName.equals("temp") && !onTem) {
                            shortWeathers.get(i).setTemp(parser.getText());
                            onTem = true;
                        }
                        if (tagName.equals("tmx") && !onTmx) {
                            shortWeathers.get(i).setTmx(parser.getText());
                            onTmx = true;
                        }
                        if (tagName.equals("tmn") && !onTmn) {
                            shortWeathers.get(i).setTmn(parser.getText());
                            onTmn = true;
                        }
                        if (tagName.equals("wfKor") && !onWfKor) {
                            shortWeathers.get(i).setWfKor(parser.getText());
                            onWfKor = true;
                        }
                        if (tagName.equals("pop") && !onPop) {
                            shortWeathers.get(i).setPop(parser.getText());
                            onPop = true;
                        }
                        if (tagName.equals("ws") && !onWs) {
                            shortWeathers.get(i).setWs(parser.getText());
                            onWs = true;
                        }
                        if (tagName.equals("wdKor") && !onWdKor) {
                            shortWeathers.get(i).setWdKor(parser.getText());
                            onWdKor = true;
                        }
                        if (tagName.equals("reh") && !onReh) {
                            shortWeathers.get(i).setReh(parser.getText());
                            onReh = true;
                        }
                        if (tagName.equals("r06") && !onR6) {
                            shortWeathers.get(i).setR6(parser.getText());
                            onR6 = true;
                        }
                        if (tagName.equals("s06") && !onS6) {
                            shortWeathers.get(i).setS6(parser.getText());
                            onS6= true;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                        if (tagName.equals("s06") && onEnd == false) {
                            i++;
                            onHour = false;
                            onDay = false;
                            onTem = false;
                            onTmx = false;
                            onTmn = false;
                            onWfKor = false;
                            onPop = false;
                            onWs = false;
                            onWdKor = false;
                            onReh = false;
                            onR6 = false;
                            onS6 = false;
                            isItemTag1 = false;
                            onEnd = true;
                        }
                    }

                    eventType = parser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<Item> horizontalList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView date;
            public TextView time;
            public TextView weather;
            public TextView reh;
            public TextView wd;
            public TextView r6;
            public TextView ws;
            public TextView pop;

            public MyViewHolder(View view) {
                super(view);
                date = (TextView)view.findViewById(R.id.date);
                time = (TextView)view.findViewById(R.id.time);
                weather = (TextView)view.findViewById(R.id.weather);
                reh = (TextView)view.findViewById(R.id.reh);
                pop = (TextView)view.findViewById(R.id.pop);
                r6 = (TextView)view.findViewById(R.id.r6);
                ws = (TextView)view.findViewById(R.id.ws);
                wd = (TextView)view.findViewById(R.id.wd);
            }
        }

        public HorizontalAdapter(List<Item> horizontalList) {
            this.horizontalList = horizontalList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.date.setText(horizontalList.get(position).getDate());
            holder.time.setText(horizontalList.get(position).getTime());
            holder.r6.setText(horizontalList.get(position).getR6()+"mm");
            holder.pop.setText(horizontalList.get(position).getPop()+"%");
            holder.reh.setText(horizontalList.get(position).getReh()+"%");
            holder.ws.setText(horizontalList.get(position).getWs()+"m/s");
            holder.weather.setText(horizontalList.get(position).getWeather());
            holder.wd.setText(horizontalList.get(position).getWd());

            Drawable img;
            switch(horizontalList.get(position).getWeather())
            {
                case "맑음":
                    switch(horizontalList.get(position).getTime())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_1 );
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_1 );
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;
                    }
                    break;
                case "구름 조금":
                    switch(horizontalList.get(position).getTime())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_2);
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_2);
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;
                    }

                    break;
                case "구름 많음":
                    switch(horizontalList.get(position).getTime())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_3);
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_3 );
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;
                    }

                    break;

                case "흐림":
                    switch(horizontalList.get(position).getTime())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_4 );
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);

                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_4 );
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;
                    }

                    break;

                case "비":
                    switch(horizontalList.get(position).getTime())
                    {
                        case "6":case"9":case"12":case"15":
                        img = getResources().getDrawable( R.drawable.morning_5 );
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;

                        case "18":case"21":case"24":case"3":
                        img = getResources().getDrawable( R.drawable.evening_5);
                        img.setBounds(0, 25, 90, 115);
                        holder.weather.setCompoundDrawables(null, img, null, null);
                        break;
                    }

                    break;
            }
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }
}

