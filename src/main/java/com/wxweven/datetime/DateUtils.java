package com.wxweven.datetime;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 日期工具，基于 joda-time 封装
 *
 * @author wxweven
 * @date 2017/9/22
 */
public class DateUtils {
    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

    public enum DateFormat {
        DATETIME_FORMAT("yyyy-MM-dd HH:mm:ss", "年-月-日 时:分:秒"),
        DATE_FORMAT("yyyy-MM-dd", "年-月-日"),
        TIME_FORMAT("HH:mm:ss", "时:分:秒"),
        TIME_FORMAT_WITHOUT_DELIMITER("HHmmss", "时分秒");

        private String format;
        private String desc;

        DateFormat(String format, String desc) {
            this.format = format;
            this.desc = desc;
        }

        public String getFormat() {
            return format;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 将时间字符串 str 解析为 Date，时间字符串格式默认为"yyyy-MM-dd HH:mm:ss"
     *
     * @param str 待解析的时间字符串
     * @return 解析后的 Date, 字符串为空或解析异常时，返回null
     */
    public static Date str2Date(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_DATETIME_FORMAT);
            return DateTime.parse(str, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将 Date 解析为字符串，格式默认为"yyyy-MM-dd HH:mm:ss"
     *
     * @param date 待解析的 Date
     * @return 解析后的字符串；解析异常时，返回空字符串
     */
    public static String date2Str(Date date) {
        try {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(DEFAULT_DATETIME_FORMAT);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 将时间字符串 str 解析为 Date，时间字符串格式默认为"yyyy-MM-dd"
     *
     * @param str 待解析的时间字符串
     * @return 解析后的 Date, 字符串为空或解析异常时，返回null
     */
    public static Date dayStr2Date(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_DATE_FORMAT);
            return DateTime.parse(str, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将 Date 解析为字符串，格式由默认为"yyyy-MM-dd"
     *
     * @param date 待解析的 Date
     * @return 解析后的字符串；解析异常时，返回空字符串
     */
    public static String date2DayStr(Date date) {
        try {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(DEFAULT_DATE_FORMAT);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 将时间字符串 str 解析为 Date，时间字符串格式默认为"yyyy-MM-dd HH:mm"
     *
     * @param str 待解析的时间字符串
     * @return 解析后的 Date, 字符串为空或解析异常时，返回null
     */
    public static Date minuteStr2Date(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_MINUTE_FORMAT);
            return DateTime.parse(str, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将 Date 解析为字符串，格式由默认为"yyyy-MM-dd HH:mm"
     *
     * @param date 待解析的 Date
     * @return 解析后的字符串；解析异常时，返回空字符串
     */
    public static String date2MinuteStr(Date date) {
        try {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(DATE_MINUTE_FORMAT);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 将时间字符串 str 解析为 Date，时间字符串必须满足 pattern 格式
     *
     * @param str     待解析的时间字符串
     * @param pattern 指定的时间格式
     * @return 解析后的 Date, 字符串为空或解析异常时，返回null
     */
    public static Date str2Date(String str, String pattern) {
        if (StringUtils.isBlank(str)) {
            return null;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
            return DateTime.parse(str, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将 Date 解析为字符串，格式由 pattern 指定
     *
     * @param date    待解析的 Date
     * @param pattern 指定的格式
     * @return 解析后的字符串；解析异常时，返回空字符串
     */
    public static String date2Str(Date date, String pattern) {
        try {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(pattern);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 将 时间戳 解析为字符串，格式由 pattern 指定
     *
     * @param timestamp 待解析的 Date
     * @param pattern   指定的格式
     * @return 解析后的字符串；解析异常时，返回空字符串
     */
    public static String timestamp2Str(long timestamp, String pattern) {
        try {
            DateTime dateTime = new DateTime(timestamp);
            return dateTime.toString(pattern);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }
}
