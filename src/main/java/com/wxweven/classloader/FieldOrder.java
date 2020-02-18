package com.wxweven.classloader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wxweven
 */
public class FieldOrder {
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Integer> numbers2 = Arrays.asList(1, 3, 5, 7);

    static {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    public static List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> getNumbers2() {
        return numbers2;
    }
}