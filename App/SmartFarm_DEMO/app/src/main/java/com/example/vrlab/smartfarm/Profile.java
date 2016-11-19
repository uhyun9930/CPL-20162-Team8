package com.example.vrlab.smartfarm;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Profile extends ListActivity {
    static  long now = System.currentTimeMillis();
    static final Date dateInit = new Date(now);
    static    final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
    static final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
    static final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);
    static int YEAR = Integer.parseInt(curYearFormat.format(dateInit));
    static int Month = Integer.parseInt(curMonthFormat.format(dateInit));
    static int date = Integer.parseInt(curDayFormat.format(dateInit));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadDB();
    }
    @Override
    public void onResume(){
        super.onResume();
        loadDB();
    }
    public void loadDB(){
        SQLiteDatabase db = openOrCreateDatabase(
                "plant1.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS plant (_id INTEGER PRIMARY kEY,email TEXT,name TEXT,date TEXT);"); //식물 이름
        Cursor c = db.rawQuery("SELECT name,date plant1;",null);
        startManagingCursor(c);
        ListAdapter adapt = new SimpleCursorAdapter(
                this,
               // android.R.layout.simple_list_item_2,
                R.layout.item1,
                c,
                new String[]{"name","date"},
                // a,b,
                new int[]{R.id.text1,R.id.text2},
                0
        );
        setListAdapter(adapt);
        if(db!=null){
            db.close();
        }
    }
    public void onInsert(View v){
        String year = String.valueOf(YEAR);
        String month = String.valueOf(Month);
        String date_ = String.valueOf(date);
        String today = year+"년"+month+"월"+date_+"일";
        final String _today = year+"."+month+"."+date_;
        final EditText plant_name = new EditText(getApplicationContext());
        new AlertDialog.Builder(Profile.this)
                .setTitle("오늘 날짜는 "+today)
                .setMessage("식물을 입력해주세요")
                .setView(plant_name)
                //insert에 email 추가해주세요
                .setPositiveButton("입력",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String sql =
                                        "INSERT INTO plant1 (email,name,date) VALUES ('"
                                               // +email+"', '"
                                        + plant_name.getText().toString() + "', '"
                                        + _today + "');";
                                SQLiteDatabase db = openOrCreateDatabase(
                                        "plant.db",
                                        SQLiteDatabase.CREATE_IF_NECESSARY,
                                        null
                                );
                                db.execSQL(sql);
                              //  finish();
                            loadDB();
                            }
                        }).setNeutralButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql =
                        "DELETE FROM plant WHERE name = '"+plant_name.getText().toString()+"';";
              //"DELETE FROM plant WHERE name = '"+plant_name.getText().toString()+"' AND email = '"+email+';";

                SQLiteDatabase db = openOrCreateDatabase(
                        "plant.db",
                        SQLiteDatabase.CREATE_IF_NECESSARY,
                        null
                );
                db.execSQL(sql);
                loadDB();
            }
        }).setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
        loadDB();
    }
}
