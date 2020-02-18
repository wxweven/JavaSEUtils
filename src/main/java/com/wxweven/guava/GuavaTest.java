package com.wxweven.guava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wxweven
 * @date 2019/7/20
 */
public class GuavaTest {

    @Test
    public void test() {
        Set<Integer> res = new HashSet<>();

        res.addAll(Collections.emptyList());

        res.addAll(Arrays.asList(1, 2, 3));
        res.addAll(Arrays.asList(3, 4, 5));
        res.addAll(Collections.emptyList());

        System.out.println(new ArrayList<>(res));

    }
}
