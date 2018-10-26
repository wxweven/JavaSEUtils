package com.algorithm.zuochengyunbook.chapter_5_stringproblem;

public class Problem_02_AllNumbersSum {

    public static int numSum(String str) {
        if (str == null) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (charArr[i] == '-') {
                    if (i - 1 > -1 && charArr[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static int numSum2(String str) {
        char[] s = str.toCharArray();
        int sum = 0;// 所有数字之和
        int num = 0;// 保存当前连续的数字
        boolean flag = true;// 判断是否为负数，true为正数
        for (int i = 0; i < s.length; i++) {
            int cur = s[i] - '0';// 当前的字符
            if (cur >= 0 && cur <= 9) {
                // 当前为数字，不管cur之前字符是否为数字，累加num
                num = num * 10 + (flag ? cur : -cur);
            } else {
                // 遇到不是数字的字符，先把之前的数字num累加到sum
                sum += num;
                num = 0;// 遇到不是数字的字符，将num赋值为0
                if (s[i] == '-') {// 判断当前字符是否是'-'
                    if (i > 0 && s[i - 1] == '-') {// 如果当前的'-'的上一个字符也是'-'，则将flag取反。
                        flag = !flag;
                    } else {
                        flag = false;// 如果当前的'-'上一个字符不是'-',需要将flag重新赋值为false
                    }
                } else {
                    flag = true;// 如果当前字符不是'-',需要将flag重新赋值为true，只有连续的'-'才会累加取反。
                }
            }
        }

        sum += num;
        return sum;
    }

    public static int numSum3(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("字符串不能为空");
        }

        str = str.trim();

        char[] chars = str.toCharArray();
        int sum = 0;// 总和
        int num = 0;//记录当前轮次数值
        boolean positive = true;// 标记是否为正数

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            int curInt = curChar - '0';

            if (curInt >= 0 && curInt <= 9) {
                // 当前为数字，累加到num上
                num = num * 10 + (positive ? curInt : -curInt);
            } else {
                // 当前字符不是数字，把之前的num汇总，num重新开始累加
                sum += num;
                num = 0;
                if (curChar == '-') {
                    if (i > 0 && chars[i - 1] == '-') {
                        // 前一个也是负号，反转标记
                        positive = !positive;
                    } else {
                        positive = false;
                    }
                } else {
                    // 其他符号，表示重新开始累加num，标记默认为true
                    positive = true;
                }
            }
        }

        sum += num;

        return sum;
    }


    public static void main(String[] args) throws Exception {
//        String test = "-1K-100ABC500D-T--100F200G!!100H---3-00";
//        String test = "-1K-100ABC500D-T--100F200G!!-1.00H----3-00";
        String test = "---3-5";
        System.out.println(numSum(test));
        System.out.println(numSum2(test));
        System.out.println(numSum3(test));

    }

}
