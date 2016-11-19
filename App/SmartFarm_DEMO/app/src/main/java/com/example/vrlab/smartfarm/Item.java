package com.example.vrlab.smartfarm;

/**
 * Created by ASUS TP300L on 2016-11-14.
 */

public class Item {
    private String date;
    private String time;
    private String weather;
    private String pop;
    private String r6;
    private String wd;
    private String ws;
    private String reh;

    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getWeather() {
        return weather;
    }
    public String getPop() {
        return pop;
    }
    public String getR6() {
        return r6;
    }
    public String getWd() {
        return wd;
    }
    public String getWs() {
        return ws;
    }
    public String getReh() {
        return reh;
    }

    public Item(String date, String time, String weather, String pop, String r6, String reh, String ws, String wd)
    {
        this.date=date;
        this.time = time;
        this.weather = weather;
        this.pop = pop;
        this.r6=r6;
        this.reh=reh;
        this.ws = ws;
        this.wd=wd;
    }
}
