package com.wxweven.datetime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateTimeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeTest.class);

    @Test
    public void testDaysBetween() {

        LocalDateTime localDateTime = LocalDateTime.now();
        LOGGER.info("localDateTime={}", localDateTime);

        DateTime dateTime2 = DateTime.now();
        LOGGER.info("dateTime={}", dateTime2);

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime d1 = DateTime.parse("2017-03-22 23:59:59", format);
        DateTime d2 = DateTime.parse("2017-03-22 00:00:00", format);

//        Assert.assertEquals(DateUtils.isSameDay(d1.toDate(), d2.toDate()), true);

        int days = Days.daysBetween(d1, d2).getDays();
        LOGGER.info("days: {}", days);

        DateTime dateTime = new DateTime();
        DateTime dateTime1 = dateTime.minusHours(1);

        int hourOfDay = dateTime1.getHourOfDay();
        int minuteOfHour = dateTime1.getMinuteOfHour();
        int secondOfMinute = dateTime1.getSecondOfMinute();

        System.out.println(hourOfDay);
        System.out.println(minuteOfHour);
        System.out.println(secondOfMinute);

        String timestamp2Str = DateUtils.timestamp2Str(dateTime1.getMillis(), "HHmmss");
        System.out.println(timestamp2Str);

    }

    @Test
    public void testStartDate() {
        DateTime dateTime = new DateTime();
        System.out.println(DateUtils.date2Str(dateTime.toDate()));

        DateTime dateTime1 = dateTime.withTimeAtStartOfDay()
                .withDayOfMonth(1);

        System.out.println(DateUtils.date2Str(dateTime1.toDate()));
    }

    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1101, 2);
        map.put(1102, 5);
        map.put(1103, 8);
        map.put(1104, 1);
        map.put(1105, 2);


        List<Integer> ids = Arrays.asList(1101, 1102, 1103, 1104, 1105);
        ids.sort(Comparator.comparingInt(map::get));

        System.out.println(ids);
    }

    @Test
    public void testTimeZone() {
        DateTime dateTime1 = new DateTime("1970-01-01", DateTimeZone.forID("+00:00"));
        LOGGER.info("dateTime1={}", dateTime1);

        System.out.println(dateTime1.getMillis());

        Date date = new Date(0);
        System.out.println(date.getHours());

        DateTime dateTime = new DateTime(0L).withZone(DateTimeZone.forID("+09:00"));
        int hourOfDay = dateTime.getHourOfDay();
        LOGGER.info("hour={}", hourOfDay);
        LOGGER.info("day={}", dateTime.getDayOfMonth());
        System.out.println(dateTime);

        LocalDateTime localDateTime = new LocalDateTime(0L);
        LOGGER.info("local hour={}", localDateTime.getHourOfDay());
        LOGGER.info("local day={}", localDateTime.getDayOfMonth());

    }

    @Test
    public void test2() {
        long epochSecond = Instant.now().minus(40, ChronoUnit.DAYS).getEpochSecond();
        System.out.println(epochSecond);

        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.now();
        long endTime = getHourReportTime(localDateTime.toLocalDate(), localDateTime.getHour());
        System.out.println(endTime);
    }

    public static long getHourReportTime(LocalDate localDate, int hour) {
        java.time.LocalDateTime todayStart = java.time.LocalDateTime.of(localDate, LocalTime.MIN);
        java.time.LocalDateTime todayHour = todayStart.plusHours(hour);
        return todayHour.toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
    }

    @Test
    public void test3() {
        long date = getDate("2020-03-12");
        System.out.println(date);

        long time = DateUtils.str2Date("2020-03-12", "yyyy-MM-dd").getTime() / 1000;
        System.out.println(time);

        long time2 = DateTime.now(DateTimeZone.forOffsetHours(8)).withTimeAtStartOfDay().getMillis() / 1000;
        System.out.println(time2);

        long time3 = DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay().getMillis() / 1000;
        System.out.println(time3);

        Assert.assertEquals(time, date);
        Assert.assertEquals(time2, date);

        System.out.println(java.time.LocalDateTime.now().get(ChronoField.HOUR_OF_DAY));
    }

    private long getDate(String dateStr) {
        java.time.format.DateTimeFormatter dayFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());
        return LocalDate.parse(dateStr, dayFormatter)
                .atStartOfDay(ZoneOffset.ofHours(8))
                .toEpochSecond();
    }
}
