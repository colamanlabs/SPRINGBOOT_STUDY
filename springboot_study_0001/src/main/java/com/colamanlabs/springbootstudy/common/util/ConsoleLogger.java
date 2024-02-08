package com.colamanlabs.springbootstudy.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleLogger
{
    
    public static void println(String msg)
    {
        String thrName = Thread.currentThread().getName();
        String timestamp = getTimestamp();
        String msgAll = String.format("[%s][%s]\tmsg:[%s]", timestamp, thrName, msg);
        System.out.println(msgAll);
    }
    
    public static String getTimestamp()
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(c.getTime());
        return timestamp;
    }
}
