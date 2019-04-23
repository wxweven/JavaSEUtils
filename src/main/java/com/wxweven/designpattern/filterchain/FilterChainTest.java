/**
 * @(#)Test.java, Apr 18, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.filterchain;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author wangxw03
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