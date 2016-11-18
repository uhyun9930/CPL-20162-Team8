package com.example.vrlab.smartfarm;

import java.text.DecimalFormat;

public class ShortWeather {
    private String hour;  // 시간
    private String day; // 오늘/내일/모레
    private String temp;  // 온도
    private String wfKor; // 상태
    private String pop; // 강수확률
    private String reh; // 습도
    private String wdKor; // 풍향
    private String ws; // 풍속
    private String tmx;
    private String tmn;
    private String r6;
    private String s6;
    private String pattern = "#####.#";

    public String getTmx() {
        return tmx;
    }

    public void setTmx(String tmx) {
        this.tmx = tmx;
    } // 최고온도

    public String getTmn() {
        return tmn;
    }

    public void setTmn(String tmn) {
        this.tmn = tmn;
    } // 최저온도

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    } //오늘/내일/모레

    public String getReh() {
        return reh;
    }

    public void setReh(String reh) {
        this.reh = reh;
    } // 습도

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    } // 강수확률

    public void setHour(String hour) {
        this.hour = hour;
    } // 현재시간

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setWfKor(String wfKor) {
        this.wfKor = wfKor;
    }// 현재날씨

    public void setR6(String r6) {
        DecimalFormat dformat = new DecimalFormat(pattern);
        this.r6 = dformat.format(Double.parseDouble(r6));
    }
    public void setS6(String s6) {
        this.s6 = s6;
    }

    public String getHour() {
        return hour;
    }

    public String getTemp() {
        return temp;
    }

    public String getWfKor() {
        return wfKor;
    }

    public String getR6() {
        return r6;
    }
    public String getS6() {
        return s6;
    }
    public void setWs(String ws) {
        DecimalFormat dformat = new DecimalFormat(pattern);
        this.ws = dformat.format(Double.parseDouble(ws));
    }
    public void setWdKor(String wdKor) {
        this.wdKor = wdKor;
    }
    public String getWs() {
        return ws;
    }
    public String getWdKor() {
        return wdKor;
    }
}
