/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-09
 */
package com.beautifulchina.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期时间工具
 */
public class DateUtil {

    /**
     * 隐藏工具类的构造方法
     */
    protected DateUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * 时间格式常量yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_LONG_ONE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式常量yyyy-MM-dd HH:mm
     */
    public static final String DATE_FORMAT_LONG = "yyyy-MM-dd HH:mm";
    /**
     * 时间格式常量yyyy-MM-dd
     */
    public static final String DATE_FORMAT_SIMPLE = "yyyy-MM-dd";
    public static final String DATE_TAIL_START = " 00:00:00";
    public static final String DATE_TAIL_END = " 23:59:59";

    /**
     * 获得当前时间，格式 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentDate() {
        String date  = getCurrentDate(DATE_FORMAT_LONG_ONE);
        return date;
    }

    /**
     * 获得当前时间，格式自定义
     * @param format
     * @return
     */
    public static String getCurrentDate(String format) {
        Calendar day = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 获得昨天时间，格式自定义
     * @param format
     * @return
     */
    public static String getYesterdayDate(String format) {
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(day.getTime());
        return date;
    }

    /**
     * 获取每个月的第一天时间
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, 1, 0, 0, 0);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LONG_ONE);
        String date = sdf.format(c.getTime());
        return date;
    }

    /**
     * 获取每个月的最后一天时间
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, 1, 23, 59, 59);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LONG_ONE);
        String date  = sdf.format(c.getTime());
        return date;
    }

    /**
     * yyyy-MM-dd HH:mm:ss格式时间转换成其他格式
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static String getDateString(String date, String format) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(new SimpleDateFormat(DATE_FORMAT_LONG_ONE).parse(date));
        return dateStr;
    }

    /**
     * date类型日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String getDateString(Date date,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 字符串型日期转换成时间型
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date getDate(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dateTime = sdf.parse(date);
        return dateTime;
    }

    /**
     * 字符串型日期转换成时间型（默认格式：yyyy-MM-dd HH:mm:ss)
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_LONG_ONE);
        Date dateTime = sdf.parse(date);
        return dateTime;
    }

    /**
     * 转换指定时区的时间
     * @param date
     * @param formate
     * @param timeZoneId
     * @return
     */
    public static String getTimeZoneDate(Date date,String formate,String timeZoneId){
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        String formatDate = sdf.format(date);
        return formatDate;
    }

    public static Date getTimeZoneDate(String date,String formate,String timeZoneId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        Date objDate = sdf.parse(date);
        return objDate;
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(getTimeZoneDate(date,DATE_FORMAT_LONG_ONE,"America/Los_Angeles"));
        System.out.println(getTimeZoneDate("2015-11-09 01:29:07",DATE_FORMAT_LONG_ONE,"America/New_York"));
    }
}
