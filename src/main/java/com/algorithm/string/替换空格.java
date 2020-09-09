package com.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wxweven
 */
public class 替换空格 {

    public char[] replaceBlank(char[] str) {
        if (str == null || str.length == 0) {
            return str;
        }

        int numOfBlank = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                numOfBlank++;
            }
        }

        char[] newStr = new char[str.length + (numOfBlank << 1)];
        System.arraycopy(str, 0, newStr, 0, str.length);
        int oldIndex = str.length - 1;
        int newIndex = newStr.length - 1;

        while (oldIndex >= 0 && newIndex > oldIndex) {
            if (newStr[oldIndex] == ' ') {
                newStr[newIndex--] = '0';
                newStr[newIndex--] = '2';
                newStr[newIndex--] = '%';

            } else {
                newStr[newIndex--] = newStr[oldIndex];
            }

            oldIndex--;
        }

        return newStr;
    }

    @Test
    public void test() {
        String str = " a b";
        String newStr = new String(replaceBlank(str.toCharArray()));

        Assert.assertEquals("%20a%20b", newStr);
    }
}