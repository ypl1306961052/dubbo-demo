/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ypl.test.common.util.util;


import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
    public static final String DATETIME_SHORT_FORMAT = "yyyyMMddHHmmss";
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);
    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyyMMdd",
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        if (date == null) {
            return null;
        }
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * @return java.lang.String
     * @Author: FryTsui
     * @Description 获取制定日期的年月
     * @Date: 2019-07-03 15:26
     * @Param [date] 当前日期传空
     */

    public static String getYearAndMonth(Date date) {
        if (date != null) {
            return formatDate(date, "yyyy-MM");
        } else {
            return formatDate(new Date(), "yyyy-MM");
        }

    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date minusSeconds(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, Calendar.SECOND - amount);
        return cal.getTime();
    }

	/*public static long pastYears(Date date) {
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(date);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);


	}
*/

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 获取两个日期之间的毫秒数
     *
     * @param before
     * @param after
     * @return
     */
    public static long getDisSecondOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return afterTime - beforeTime;
    }

    /**
     * 自定义字符串样式
     */
    public static String formatDateTimezdy(Date date) {
        return formatDate(date, "yyyyMMddHHmm");
    }

    /**
     * 将日期添加上时分秒
     */
    public static Date formatDateAndTime(Date date, int hours) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR, hours);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();

    }

    /**
     * 根据指定的Format转化java.util.Date到String
     *
     * @param dt   java.util.Date instance
     * @param sFmt Date format , DATE_FORMAT_DATEONLY or DATE_FORMAT_DATETIME
     * @return
     * @history
     * @since 1.0
     */
    public static String toString(Date dt, String sFmt) {
        if (dt == null || sFmt == null || "".equals(sFmt)) {
            return "";
        }
        return toString(dt, new SimpleDateFormat(sFmt));
    }

    /**
     * 利用指定SimpleDateFormat instance转换java.util.Date到String
     *
     * @param dt        java.util.Date instance
     * @param formatter SimpleDateFormat Instance
     * @return
     * @history
     * @since 1.0
     */
    private static String toString(Date dt, SimpleDateFormat formatter) {
        String sRet = null;

        try {
            sRet = formatter.format(dt).toString();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            sRet = null;
        }

        return sRet;
    }

    /**
     * 获取几秒钟前的date
     *
     * @param second
     * @return
     */
    public static Date pastSecond(Integer second) {
        long t = System.currentTimeMillis() - second * 1000;
        return new Date(t);
    }


    /**
     * 获取几秒钟后的date
     *
     * @param second
     * @return
     */
    public static Date afterSecond(Integer second) {
        long t = System.currentTimeMillis() + second * 1000;
        return new Date(t);
    }

    public static Date getPurposeDays(Date oriDate, int addDays, int addHours, int addMinutes, int addSeconed) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oriDate);
        calendar.add(Calendar.DAY_OF_MONTH, addDays);
//		 calendar.set(Calendar.HOUR_OF_DAY, addHours);
//		 calendar.set(Calendar.MINUTE, addMinutes);
//		 calendar.set(Calendar.SECOND, addSeconed);
        return calendar.getTime();
    }

    /**
     * @return java.util.Date
     * @Author: FryTsui
     * @Description 给date增加num个月
     * @Date: 2019-07-02 14:23
     * @Param [date, num]
     */

    public static Date addMonth(Date date, Integer num) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        calendar.add(Calendar.MONTH, num);

        return calendar.getTime();
    }

    public static Date addDate(Date date, Integer num) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        Date d = cal.getTime();
        return d;
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Date a = weekToThisDay(1);
    }


    /**
     * @return java.lang.String
     * @Author MIKE
     * @Description 根据周几 获取本周日期
     * @Date 11:09 2020/5/8
     * @Param [week]
     **/
    public static Date weekToThisDay(int week) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTimeToDate(date));
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(week);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * @return java.lang.String
     * @Author MIKE
     * @Description 根据周几，获取下周日期
     * @Date 11:09 2020/5/8
     * @Param [week]
     **/
    public static Date weekToNextDay(int week) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(weekToThisDay(week));
            cal.add(Calendar.DATE, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cal.getTime();
    }

    /**
     * @return java.util.Date
     * @Author MIKE
     * @Description 根据号数，获取当月日期
     * @Date 15:18 2020/5/8
     * @Param [day]
     **/
    public static Date getThisDay(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTimeToDate(new Date()));
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * @return java.util.Date
     * @Author MIKE
     * @Description 根据号数，获取下月日期
     * @Date 15:18 2020/5/8
     * @Param [day]
     **/
    public static Date getNextDay(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 1);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * @return java.util.Date
     * @Author MIKE
     * @Description 给日期添加时间
     * @Date 14:32 2020/5/8
     * @Param [date, time]
     **/
    public static Date getNewDate(Date date, Date time) {
        SimpleDateFormat operationDateTime = new SimpleDateFormat(DATETIME_PATTERN);
        SimpleDateFormat operationDate = new SimpleDateFormat(DATE_PATTERN);
        SimpleDateFormat operationTime = new SimpleDateFormat(TIME_PATTERN);
        Date resultDate = null;
        try {
            resultDate = operationDateTime.parse(operationDate.format(date) + " " + operationTime.format(time));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * @return java.util.Date
     * @Author MIKE
     * @Description 获取 DateTime 的 Date
     * @Date 19:18 2020/5/8
     * @Param [date]
     **/
    public static Date dateTimeToDate(Date date) {
        SimpleDateFormat operationDate = new SimpleDateFormat(DATE_PATTERN);
        Date resultDate = null;
        try {
            resultDate = operationDate.parse(operationDate.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDate;
    }


    /**
     * @return java.util.Date
     * @Author MIKE
     * @Description 获取 DateTime 的 Time
     * @Date 19:18 2020/5/8
     * @Param [date]
     **/
    public static Date dateTimeToTime(Date date) {
        SimpleDateFormat operationTime = new SimpleDateFormat(TIME_PATTERN);
        Date resultDate = null;
        try {
            resultDate = operationTime.parse(operationTime.format(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * @return int
     * @Author MIKE
     * @Description 根据日期 获取计算是星期几
     * @Date 19:54 2020/5/8
     * @Param [date]
     **/
    public static int dateToWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * @return int
     * @Author MIKE
     * @Description 根据日期 获取计算是几号
     * @Date 19:54 2020/5/8
     * @Param [date]
     **/
    public static int dateToDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return java.util.Date
     * @Author MIKE
     * @Description 时分秒字符串转Date
     * @Date 17:03 2020/5/9
     * @Param [time]
     **/
    public static Date stringTimeToDate(String time) {
        SimpleDateFormat operationTime = new SimpleDateFormat(TIME_PATTERN);
        if (null == time || "".equals(time)) {
            return null;
        }
        Date date = null;
        try {
            date = operationTime.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug("错误时间：" + time + "--error:" + e.toString());
        }
        return date;
    }
}
