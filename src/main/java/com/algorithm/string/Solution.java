package com.algorithm.string;

import org.junit.Test;

public class Solution {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] charArr = s.toCharArray();

        int low = 0;
        int high = charArr.length - 1;

        while (low < high) {
            if (!Character.isLetterOrDigit(charArr[low])) {
                low++;
            } else if (!Character.isLetterOrDigit(charArr[high])) {
                high--;
            } else {
                if (Character.toLowerCase(charArr[low]) != Character.toLowerCase(charArr[high])) {
                    return false;
                }

                low++;
                high--;
            }
        }

        return true;
    }

    @Test
    public void test() {
        boolean palindrome = Solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}