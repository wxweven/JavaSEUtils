/**
 * @(#)SortTest.java, Jul 02, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.guava;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangxw03
 */
public class SortTest {

    private List<JavaBean> javaBeans;

    private List<Integer> allBeanIds;

    @Before
    public void init() {
        javaBeans = Arrays.asList(
                new JavaBean(1, "name1"),
                new JavaBean(8, "name8"),
//                new JavaBean(3, "name3"),
                new JavaBean(5, "name5"),
                new JavaBean(6, "name6")
        );


    }


    @Test
    public void test() {
        Map<Integer, JavaBean> javaBeanMap = javaBeans.stream()
                .collect(Collectors.toMap(JavaBean::getId, Function.identity()));

        allBeanIds = Arrays.asList(1, 3, 5, 6);
        List<Integer> sortedIds = Arrays.asList(1, 5, 8, 6, 3);
        List<JavaBean> sortedList = sortedIds.stream()
                .map(javaBeanMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Collection<Integer> unSortedIds = CollectionUtils.subtract(allBeanIds, sortedIds);
        System.out.println("unSortedIds=" + unSortedIds);

        List<JavaBean> unSortedList = unSortedIds.stream()
                .map(javaBeanMap::get)
                .collect(Collectors.toList());

//        Ordering<JavaBean> orderById = Ordering.explicit(sortedIds).onResultOf(JavaBean::getId);
//        List<JavaBean> sortedList = orderById.immutableSortedCopy(this.javaBeans);
        System.out.println("sortedList=" + sortedList);

        List<JavaBean> finalBeans = ListUtils.union(sortedList, unSortedList);
        System.out.println("finalBeans=" + finalBeans);
    }
}

