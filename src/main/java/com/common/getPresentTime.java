package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 祎婷 on 2014/12/2.
 */
public class getPresentTime {
    private  Date presenttime = new Date();
    private  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private  String date  = format.format(presenttime);
    public  String getTime(){
        return date;
    }
}
