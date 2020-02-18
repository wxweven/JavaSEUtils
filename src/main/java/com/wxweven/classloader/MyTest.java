package com.wxweven.classloader;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wxweven
 */
public class MyTest {
    @Test
    public void test() {
//        System.out.println(FieldOrder.getNumbers());
//        System.out.println(FieldOrder.getNumbers2());
//        System.out.println(FieldOrder.getNumbers2());

//        long startSaleTime = 1572840000000L;
//
//        long day = 24 * 60 * 60 * 1000;
//        long l = startSaleTime % day;
//        System.out.println("l:" + l);
//
//        long pointTs = startSaleTime - l + day;
//        System.out.println("pointTs:" + pointTs);
//
//        long l1 = System.currentTimeMillis();
//        System.out.println("l1:" + l1);
//        boolean b = l1 >= pointTs;
//        System.out.println(b);

        List<Integer> integers = Stream.of(1, 2, 3)
                .filter(i -> i > 4)
                .collect(Collectors.toList());
        int size = integers.size();
        System.out.println(size);
        System.out.println(integers);
    }
}