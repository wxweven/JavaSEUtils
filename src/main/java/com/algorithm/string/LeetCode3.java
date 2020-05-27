package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {

    /*
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a
     */


    /**
     * 视频讲解：https://www.youtube.com/watch?v=fBiiKy8kwaY
     * 基本思路：双指针；有别于数组的双指针（left往右, right往左)
     * 字符串的双指针，通常是left起点，然后i往后遍历
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 1;
        Map<Character, Integer> map = new HashMap<>();

        // left 代表不重复的字符串的起点
        for (int i = 0, left = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                // 说明有重复的了，left设为当前重复字符c的下一个
                // 但是left不能往回走，所以必须取 max
                left = Math.max(left, map.get(c) + 1);
            }

            // 下面两步是每次循环都需要做的
            res = Math.max(res, i - left + 1);
            map.put(c, i);
        }

        return res;
    }

}
