/**
 * @(#)ListTest.java, Apr 26, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangxw03
 */
public class ListTest {
    @Test
    public void testRetain() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 5, 6);
        List<Integer> list3 = Arrays.asList(4, 5, 6);

        boolean containsAny1 = CollectionUtils.containsAny(list1, list2);
        boolean containsAny2 = CollectionUtils.containsAny(list2, list1);
        Assert.assertTrue(containsAny1);
        Assert.assertTrue(containsAny2);

        boolean containsAny3 = CollectionUtils.containsAny(list1, list3);
        Assert.assertFalse(containsAny3);

        List<Integer> retainAll1 = ListUtils.retainAll(list1, list2);
        List<Integer> retainAll2 = ListUtils.retainAll(list2, list1);
        System.out.println(retainAll1);
        System.out.println(retainAll2);
    }


    @Test
    public void testSort() {
        List<Integer> fullSortedIds = Arrays.asList(3, 7, 9, 8, 6, 89, 66, 8908);

        int startId = 7;
        int limit = 3;

        int skipCount = startId == 0 ? 0 : fullSortedIds.indexOf(startId);
        skipCount = skipCount == -1 ? 0 : skipCount;

        List<Integer> sortedCoinGoodsIds = fullSortedIds.stream().skip(skipCount).limit(limit)
                .collect(Collectors.toList());

        System.out.println(sortedCoinGoodsIds);
    }
}