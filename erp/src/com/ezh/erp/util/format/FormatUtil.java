package com.ezh.erp.util.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-11.
 */
public class FormatUtil {
    public static final String formatDate(Long birthday){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date(birthday));
    }
    public static final String formatTime(Long birthday){
        DateFormat df = new SimpleDateFormat("hh:MM:ss");
        return df.format(new Date(birthday));
    }
    public static final String formatDateTime(Long birthday){
        DateFormat df = new SimpleDateFormat("yy-MM-dd hh:MM:ss");
        return df.format(new Date(birthday));
    }
}
