package com.zhouw.common.util.common;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/5/10.
 * @since v1.0
 */
public class CalendarUtil {


    /**
     * 获取给定日期的零点时间（00:00:00 000）
     *
     * @param value 给定的时间
     * @return 给定日期的开始时间点（00:00:00 000）
     */
    public static Calendar beginCalendarOfDate(Calendar value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value.getTime());
        setTimeExceptDate(calendar, 0, 0, 0, 0);
        return calendar;
    }

    /**
     * 获取给定日期的开始时间点（00:00:00 000）
     *
     * @param value 给定的时间
     * @return 给定日期的开始时间点（00:00:00 000）
     */
    public static Calendar beginCalendarOfDate(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        return beginCalendarOfDate(calendar);
    }

    /**
     * 获取给定日期的结束时间点（23:59:59 999）
     *
     * @param value 给定的时间
     * @return 给定日期的零点时间（23:59:59 999）
     */
    public static Calendar endCalendarOfDate(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        return endCalendarOfDate(calendar);
    }

    /**
     * 获取给定日期的结束时间点（23:59:59 999）
     *
     * @param value 给定的时间
     * @return 给定日期的零点时间（23:59:59 999）
     */
    public static Calendar endCalendarOfDate(Calendar value) {
        setTimeExceptDate(value, 23, 59, 59, 999);
        return value;
    }

    /**
     * 设置给定日期的时分秒
     *
     * @param calendar    给定日期
     * @param hour        需设定的小时
     * @param minuter     需设定的分钟
     * @param second      需设定的秒
     * @param millisecond 需设定的毫秒
     */
    public static void setTimeExceptDate(Calendar calendar, int hour, int minuter, int second, int millisecond) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minuter);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
    }


}
