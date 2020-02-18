package com.wxweven.jmh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * @author wangxw03
 */
public class DistinctUtils {
    public static Predicate<TestData> distinctByKey(Function<TestData, String> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static void distinct1(List<TestData> users) {
        Set<String> names = new HashSet<>();
        List<TestData> distinctUsers = new ArrayList<>();
        for (TestData user : users) {
            String name = user.getName();
            if (names.contains(name)) {
                // 已经存在，直接忽略，处理下一个 boxItem
                continue;
            }

            distinctUsers.add(user);
            names.add(name);
        }
    }

    public static void distinct2(List<TestData> users) {
        List<TestData> distinctUsers = users.stream()
                .filter(DistinctUtils.distinctByKey(TestData::getName))
                .collect(toList());
    }
}