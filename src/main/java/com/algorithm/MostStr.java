package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxweven
 * @date 2018/10/23
 */
public class MostStr {

    public static final String SPLIT_CHAR = " ";
    public static final String EXCLUDE_STR = "[!-?,:;.]";

    public static void findMost(String inputStr) {
        if (inputStr == null || inputStr.length() == 0) {
            System.out.println("input str is error!");
            return;
        }

        inputStr = inputStr.trim();
        String[] splitStrs = inputStr.split(SPLIT_CHAR);
        Map<String, Integer> strTimesMap = new HashMap<>();
        int maxTimes = 0;
        for (String str : splitStrs) {
            String newStr = str.toLowerCase().replaceAll(EXCLUDE_STR, "");
            if (strTimesMap.containsKey(newStr)) {
                int times = strTimesMap.get(newStr) + 1;
                strTimesMap.put(newStr, times);
                maxTimes = times;
            } else {
                strTimesMap.put(newStr, 1);
            }
        }

        if (maxTimes == 0) {
            maxTimes = 1;
        }
        int maxValue = maxTimes;

        strTimesMap.entrySet()
                   .stream()
                   .filter(entry -> entry.getValue() == maxValue)
                   .map(Map.Entry::getKey)
                   .sorted()
                   .forEach(str -> System.out.print(str + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        MostStr.findMost("aa bb cc dd aa");
        MostStr.findMost("aa bb cc dd bb");
        MostStr.findMost("aa bb cc dd");
        MostStr.findMost("aa; bb cc dd aa.");
        MostStr.findMost("i buy an apple watch from the aPple store, by the way I also like eating apple.");
    }
}
