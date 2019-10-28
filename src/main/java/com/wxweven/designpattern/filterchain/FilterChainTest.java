package com.wxweven.designpattern.filterchain;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author wxweven
 */
public class FilterChainTest {
    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);

        Integer first = list.getFirst();
    }
}