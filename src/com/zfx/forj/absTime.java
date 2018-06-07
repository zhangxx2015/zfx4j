package com.zfx.forj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangxx on 2018-05-22.
 */
public class absTime {
    private static DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static String getDate(){
        return dateFormat.format(new Date().getTime());
    }
    public static String getTime(){
        return timeFormat.format(new Date().getTime());
    }

    // 计算当前绝对时间
    public static Long absSecs() {
        return new Date().getTime()/1000;
    }
}
