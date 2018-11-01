package com.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 * @date 2018/10/28
 */
public class 字符串反转 {

    @Test
    public void testReverse() {
        String str1 = reverse("www.baidu.com");
        System.out.println(str1);
        Assert.assertTrue(str1.equals("moc.udiab.www"));

        String str2 = reverse("a");
        System.out.println(str2);
        Assert.assertTrue(str2.equals("a"));

        String str3 = reverse("ab");
        System.out.println(str3);
        Assert.assertTrue(str3.equals("ba"));
    }

    public static String reverse(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        int len = str.length();
        if (len == 1) {
            return str;
        }

        int mid = (len + 1) >> 1;
        char tmp;
        char[] chars = str.toCharArray();
        for (int i = 0; i < mid; i++) {
            tmp = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = tmp;
        }

        return new String(chars);
    }
}
