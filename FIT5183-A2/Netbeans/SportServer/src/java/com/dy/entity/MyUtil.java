/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dy.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dy
 */
public class MyUtil {

    public static String getid() {
        return UUID.randomUUID().toString();
    }

    public static Date getDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//        Date d = null;  
//        try {
//            d = sdf.parse(getDate().toString());
//        } catch (ParseException ex) {
//            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return d;
        return new Date();
    }

    public static Date transTime(String timeString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(timeString);
        } catch (ParseException ex) {
            Logger.getLogger(MyUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(date);
        return date;

    }
    
    public static String getCurTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
//        System.out.println(time);
        return time;
    }

}
