/**
 * @(#)CourseMatcherChainHelper.java, Jul 31, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxweven
 */
public class CourseMatcherChainHandler {
    private List<CourseMatcher> courseMatchers = new ArrayList<>();
    private int currentMatcherIndex = 0;

    public boolean addMatcher(CourseMatcher courseMatcher) {
        courseMatcher.setMatcherChainHandler(this);
        return courseMatchers.add(courseMatcher);
    }

    public void initMatchers(List<CourseMatcher> matchers) {
        if (CollectionUtils.isEmpty(matchers)) {
            throw new RuntimeException("initMatchers error, courseMatchers is empty");
        }

        for (CourseMatcher matcher : matchers) {
            matcher.setMatcherChainHandler(this);
        }

        courseMatchers.addAll(matchers);
    }

    public CourseMatcher getNextMatcher() {
        if (CollectionUtils.isEmpty(courseMatchers)) {
            throw new RuntimeException("courseMatchers has not been init");
        }

        if (currentMatcherIndex >= courseMatchers.size() - 1) {
            return null;
        }

        return courseMatchers.get(++currentMatcherIndex);
    }

    public CourseMatcher getFirstMatcher() {
        if (CollectionUtils.isEmpty(courseMatchers)) {
            throw new RuntimeException("courseMatchers has not been init");
        }

        return courseMatchers.get(0);
    }

    public boolean doMatch(Course course) {
        return getFirstMatcher().match(course);
    }
}