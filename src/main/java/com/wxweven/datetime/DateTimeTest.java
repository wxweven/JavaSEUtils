package com.wxweven.datetime;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateTimeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeTest.class);

    @Test
    public void testDaysBetween() {
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

}
