package com.algorithm.string;
/*
 * 面试题4，实现一个函数，把字符串中的空格替换为%20。
 * 思路1：用另一个String进行复制或者替换比较方便。
 *
 * 思路2：先统计空格数量，确定扩长后的String总长度，一个指针a在原始字符串末尾，一个指针b在扩长后的字符串末尾。向前移动a，把字符复制给b，直到遇到空格。
 *
 * 思路3：遇到空格就后移字符，这是不好的方法，复杂度n*n。所以如果合并字符串或者数组时从前往后复制需要移动字符多次，那么就考虑从后往前以减少移动次数。
 * 相关题目：两个有序数组A1和A2，A1末尾有足够的空间容纳A2，请把A2插入到A1中并排好序。
 * 思路：从尾到头比较A1和A2，把较大的数字放在A1的合适位置。
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceBlank {
    static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    static String replace(String input) {
        if (input == null) {
            return null;
        }
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                output.append("%20");
                //也可以不用StringBuffer，用数组去做，即char[] xxx=input.toCharArray();
            } else {
                output.append(input.charAt(i));
            }
        }
        return new String(output);
    }

    public static void main(String[] args) {
        System.out.println(replace(input()));
    }

    public static char[] replaceBlank(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("输入的字符串有误");
            return "".toCharArray();
        }

        char[] chars = str.toCharArray();
        int origLen = chars.length;
        int count = 0;
        for (int i = 0; i < origLen; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }

        int newLen = chars.length + count * 2;
        char[] newChars = Arrays.copyOf(chars, newLen);
        int p = origLen - 1;
        int q = newLen - 1;
        while (p>=0 && q>=0){
            if(chars[p] == ' '){
                newChars[q--] = '0';
                newChars[q--] = '2';
                newChars[q--] = '%';
                p--;
            }else {
                newChars[q--] = chars[p--];
            }
        }

        return newChars;
    }

    @Test
    public void test(){
        char[] chars = replaceBlank("we are happy");
        System.out.println(new String(chars));

        Assert.assertEquals(new String(chars), "we%20are%20happy");

        char[] chars2 = replaceBlank(" we ");
        char[] chars3 = replaceBlank(" ");
        System.out.println(new String(chars2));
        System.out.println(new String(chars3));

    }
}
