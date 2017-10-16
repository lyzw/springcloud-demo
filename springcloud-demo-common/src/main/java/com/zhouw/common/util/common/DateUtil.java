package com.zhouw.common.util.common;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/5/10.
 * @since v1.0
 */
public class DateUtil {

    /**
     * 获取给定日期所在月的第一天(包括时间为0点0分0秒)
     *
     * @param date 给定的日期
     * @return 给定日期所在月份的第一天
     */
    public static Date firstDateOfMonth(Date date) {
        Calendar calendar = CalendarUtil.beginCalendarOfDate(date);
        calendar.set(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 获取给定日期所在月的最后一天(包括时间修改为23时59分59秒999毫秒)
     *
     * @param date 给定的日期
     * @return 给定日期所在月的最后一天
     */
    public static Date endDateOfMonth(Date date) {
        Calendar calendar = CalendarUtil.endCalendarOfDate(date);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获取根据给定日期增加天数后的日期
     *
     * @param date 给定的日期
     * @param days 增加的天数
     * @return 增加天数后的日期
     */
    public static Date addDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
