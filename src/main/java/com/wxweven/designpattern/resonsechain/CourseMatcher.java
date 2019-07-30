/**
 * @(#)CourseMatcher.java, Jul 30, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxw03
 */
public abstract class CourseMatcher {
    private static List<CourseMatcher> courseMatchers = new ArrayList<>();
    private static int currentMatcherIndex = 0;


    public static boolean addMatcher(CourseMatcher courseMatcher) {
        return courseMatchers.add(courseMatcher);
    }

    public static void initMatchers(List<CourseMatcher> matchers) {
        courseMatchers = matchers;
    }

    public static CourseMatcher getNextMatcher() {
        if (CollectionUtils.isEmpty(courseMatchers)) {
            throw new RuntimeException("courseMatchers has not been init");
        }

        if (currentMatcherIndex >= courseMatchers.size() - 1) {
            return null;
        }

        return courseMatchers.get(++currentMatcherIndex);
    }

    public static CourseMatcher getFirstMatcher() {
        if (CollectionUtils.isEmpty(courseMatchers)) {
            throw new RuntimeException("courseMatchers has not been init");
        }

        return courseMatchers.get(0);
    }

    protected abstract boolean match(Course course);

}