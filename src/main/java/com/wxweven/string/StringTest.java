package com.wxweven.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringTest {

    public static void main(String[] args) {
        String a = "hello";
        String b = "hello2";
        String e = "hello" + 2;
        String c = a + 2;
        final String d = a + 2;
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println(b == c);
        System.out.println(d == b);

        System.out.println(b == e);

//        Integer age = Integer.valueOf(10);
        Integer age = null;
        String str = null;


//        System.out.println(String.valueOf(age));
//        System.out.println(Integer.valueOf(str));

    }

    @Test
    public void testStringUtils() {
        String userAgent = "Mozilla/5.0 (Linux; Android 9; CLT-AL00 Build/HUAWEICLT-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.99 Mobile Safari/537.36 YuanTiKuEmbed/6.25.0";
        boolean contains = StringUtils.containsIgnoreCase(userAgent, "YuanTiKuEmbed/");
        System.out.println(contains);
        Assert.assertTrue(contains);

        String userAgent2 = "Mozilla/5.0 (Linux; Android 9; CLT-AL00 Build/HUAWEICLT-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.99 Mobile Safari/537.36";
        boolean contains2 = StringUtils.containsIgnoreCase(userAgent2, "YuanTiKuEmbed/");
        System.out.println(contains2);
        Assert.assertFalse(contains2);
    }

    @Test
    public void testStringFormat() {
        String url = "https://m.yuanfudao.ws/orders/%d/results/success";
        String format = String.format(url, 123);
        System.out.println(format);

    }

    @Test
    public void testSetSize() {
        List<Integer> numbers = Arrays.asList(1, 3, 3, 67, 89);
        Set<Integer> sets = new HashSet<>(numbers.size());

        List<Integer> result = new ArrayList<>(numbers.size());

        for (Integer i : numbers) {
            if (sets.contains(i)) {
                continue;
            }

            sets.add(i);
            result.add(i);
        }

        System.out.println(result);

    }
}
