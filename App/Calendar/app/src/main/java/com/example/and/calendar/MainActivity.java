package com.example.and.calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
        /**
     * 연/월 텍스트뷰
     */
    private TextView tvDate;
    /**
     * 그리드뷰 어댑터
     */
    private GridAdapter gridAdapter;
   // String color = "#000000";
   String color = "#0054FF";
    static int count=0;
    static int count1=0;
    /**
     * 일 저장 할 리스트
     */
    private ArrayList<String> dayList;
    /**
     * 그리드뷰
     */
    private GridView gridView;
    /**
     * 캘린더 변수
     */
    private Calendar mCal;
//    final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
//    final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
//    final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);

    static long now = System.currentTimeMillis();
    static final Date dateInit = new Date(now);
    //연,월,일을 따로 저장
    int a=0;
    String b;
    static    final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
    static final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
    static final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);
    static int YEAR = Integer.parseInt(curYearFormat.format(dateInit));
    static int Month = Integer.parseInt(curMonthFormat.format(dateInit));
    static int LastYEAR = YEAR;
    static int LastMonth = Month;
    static String YearMonthDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = (TextView)findViewById(R.id.tv_date);
        gridView = (GridView)findViewById(R.id.gridview);
        // 오늘에 날짜를 세팅 해준다.
        long now = System.currentTimeMillis();
        final Date date = new Date(now);
        //연,월,일을 따로 저장
        int a=0;
        String b;
        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);
        //현재 날짜 텍스트뷰에 뿌려줌
        //a = Integer.parseInt(curMonthFormat.format(date))-1;
        //b= String.valueOf(a);

        tvDate.setText(curYearFormat.format(date) + "/" + curMonthFormat.format(date));

        //gridview 요일 표시
        dayList = new ArrayList<String>();
        dayList.add("일");
        dayList.add("월");
        dayList.add("화");
        dayList.add("수");
        dayList.add("목");
        dayList.add("금");
        dayList.add("토");


        mCal = Calendar.getInstance();
        //이번달 1일 무슨요일인지 판단 mCal.set(Year,Month,Day)
       // mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1);
        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1);

        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
        //1일 - 요일 매칭 시키기 위해 공백 add
        for (int i = 1; i < dayNum; i++) {
            dayList.add("");
        }
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);
        gridAdapter = new GridAdapter(getApplicationContext(), dayList);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                //arg0.getAdapter().getItem(arg2).toString()
                //Toast.makeText(getApplicationContext(),LastYEAR+"년 "+LastMonth+"월 "+parent.getAdapter().getItem(position).toString()+"일", Toast.LENGTH_SHORT).show();
                YearMonthDay = LastYEAR+"년 "+LastMonth+"월 "+parent.getAdapter().getItem(position).toString()+"일";
                Log.i(YearMonthDay,"!!");
                /*AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                final EditText name = new EditText(getApplicationContext());

                alert.setTitle("MEMO").setMessage(YearMonthDay).setView(name)
                //alert.setMessage(YearMonthDay);
//                alert.setView(name);
                .setPositiveButton("입력", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            String value = name.getText().toString();
                        value.toString();
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });*/
               // alert.show();
                final EditText name = new EditText(getApplicationContext());
                final TextView check = (TextView)findViewById(R.id.check);
                String txt;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("MEMO")
                        .setMessage(YearMonthDay)
                        .setView(name)
                        .setPositiveButton("입력",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(getApplicationContext(),"메모입력",Toast.LENGTH_SHORT).show();
                                            check.setText("O");
                                        
                                    }
                                })
                        .create().show();
            }
        });
    }


    /**
     * 해당 월에 표시할 일 수 구함
     *
     * @param month
     */

    private void setCalendarDate(int month) {
        mCal.set(Calendar.MONTH, month - 1);
        for (int i = 0; i < mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayList.add("" + (i + 1));
        }
    }

    /**
     * 그리드뷰 어댑터
     *
     */

    private class GridAdapter extends BaseAdapter {
        private final List<String> list;
        private final LayoutInflater inflater;

        /**
         * 생성자
         *
         * @param context
         * @param list
         */
        public GridAdapter(Context context, List<String> list) {
            this.list = list;
            this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            ViewHolder holder1 = null;
            if (convertView == null) {

                convertView = inflater.inflate(R.layout.item_calendar_gridview, parent, false);
                holder = new ViewHolder();
                holder1 = new ViewHolder();
                holder.tvItemGridView = (TextView)convertView.findViewById(R.id.tv_item_gridview);
                holder1.tvItemGridView = (TextView)convertView.findViewById(R.id.check);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.tvItemGridView.setText("" + getItem(position));
            //해당 날짜 텍스트 컬러,배경 변경
            mCal = Calendar.getInstance();
            //오늘 day 가져옴
            Integer today = mCal.get(Calendar.DAY_OF_MONTH);
            String sToday = String.valueOf(today);
            if (sToday.equals(getItem(position))) { //오늘 day 텍스트 컬러 변경
               // holder.tvItemGridView.setTextColor(getResources().getColor(R.color.color_000000));
                holder.tvItemGridView.setTextColor(Color.parseColor(color));
            }
            return convertView;
        }
    }

    public void onLastMonth(View v){
        //count++;
        //long now1 = System.currentTimeMillis();
        //final Date date1 = new Date(now1);
        //연,월,일을 따로 저장
        //int _month;
        //int _year = 0;
        String d;
        String y;
        /*final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);
        year = Integer.parseInt(curYearFormat.format(date1));*/
        //현재 날짜 텍스트뷰에 뿌려줌
        //c = Integer.parseInt(curMonthFormat.format(date1))-count;
        //_month = Month-count;
        //_year = YEAR;
        LastMonth -= 1;
        if(LastMonth==0){
            LastMonth=12;       //_month가 -0이면
            count=0;
            LastYEAR -= 1;           //
        }
        /*if(_year != YEAR){
            _year-=1;
        }*/
        d= String.valueOf(LastMonth);
        y = String.valueOf(LastYEAR);
        Log.i(d,y);
        tvDate.setText(y + "/" + d);

        //gridview 요일 표시
        dayList = new ArrayList<String>();
        dayList.add("일");
        dayList.add("월");
        dayList.add("화");
        dayList.add("수");
        dayList.add("목");
        dayList.add("금");
        dayList.add("토");


        mCal = Calendar.getInstance();
        //이번달 1일 무슨요일인지 판단 mCal.set(Year,Month,Day)
        // mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1);
        //mCal.set(Integer.parseInt(curYearFormat.format(date1)), Integer.parseInt(d) - 1, 1);
        //mCal.set(Integer.parseInt(curYearFormat.format(date1)), Integer.parseInt(d) - 1, 1);
        mCal.set(Integer.parseInt(y), Integer.parseInt(d) - 1, 1);

        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
        //1일 - 요일 매칭 시키기 위해 공백 add
        for (int i = 1; i < dayNum; i++) {
            dayList.add("");
        }
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);
        gridAdapter = new GridAdapter(getApplicationContext(), dayList);
        gridView.setAdapter(gridAdapter);

    }
    public void onNextMonth(View v){
        //count1++;
        /*long now1 = System.currentTimeMillis();
        final Date date1 = new Date(now1);
        //연,월,일을 따로 저장
        int a=0;
        int ye = 0;*/
        String Ye;
        String b;
        /*final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);
*/
        //현재 날짜 텍스트뷰에 뿌려줌
        //a = Integer.parseInt(curMonthFormat.format(date1))-count+count1;
        //ye = Integer.parseInt(curYearFormat.format(date1));
        LastMonth +=1;
        if(LastMonth==13){
            LastMonth=1;
            LastYEAR+=1;
            //ye = ye+1;
            //a=a-12;
        }
        b= String.valueOf(LastMonth);
        Ye = String.valueOf(LastYEAR);
        tvDate.setText(Ye + "/" + b);

        //gridview 요일 표시
        dayList = new ArrayList<String>();
        dayList.add("일");
        dayList.add("월");
        dayList.add("화");
        dayList.add("수");
        dayList.add("목");
        dayList.add("금");
        dayList.add("토");


        mCal = Calendar.getInstance();
        //이번달 1일 무슨요일인지 판단 mCal.set(Year,Month,Day)
        // mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1);
        mCal.set(Integer.parseInt(Ye), Integer.parseInt(b) - 1, 1);

        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
        //1일 - 요일 매칭 시키기 위해 공백 add
        for (int i = 1; i < dayNum; i++) {
            dayList.add("");
        }
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);
        gridAdapter = new GridAdapter(getApplicationContext(), dayList);
        gridView.setAdapter(gridAdapter);

    }

    private class ViewHolder {
        TextView tvItemGridView;
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        count=0;
        count1=0;
    }
   /* public void onDateClick(View v){
        Log.i("클릭","클릭했다!!");
    }
    public void onDate(View v){
        Log.i("뭐가 클릭","클릭~`");
    }*/


}