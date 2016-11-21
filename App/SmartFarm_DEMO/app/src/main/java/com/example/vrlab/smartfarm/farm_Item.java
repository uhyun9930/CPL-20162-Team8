package com.example.vrlab.smartfarm;

/**
 * Created by ASUS TP300L on 2016-11-20.
 */

public class farm_Item {
    private String pid;
    private String pname;

    public String getPid() {
        return pid;
    }
    public String getPname() {
        return pname;
    }

    public farm_Item(String pid, String pname)
    {
        this.pid=pid;
        this.pname = pname;
    }
}
