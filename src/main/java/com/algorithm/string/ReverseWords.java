package com.algorithm.string;

import org.junit.Test;

/**
 * @author wxweven
 * @date 2019/2/16
 */
public class ReverseWords {
    @Test
    public void test(){
        String input = "Let's take LeetCode contest";

        String output = reverseWords(input);

        System.out.println(output);
    }

    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            char[] cs = str[i].toCharArray();
            str[i] = reverseStr(cs);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if(i == 0){
                sb.append(str[i]);
            } else {
                sb.append(" ").append(str[i]);
            }
        }

        return sb.toString();
    }

    public static String reverseStr(char[] s) {
        if (s == null || s.length == 0) {
            return null;
        }
        int j = s.length - 1;
        for (int i = 0; i < j - i; i++) {
            char temp = s[i];
            s[i] = s[j - i];
            s[j - i] = temp;
        }

        return new String(s);
    }
}
