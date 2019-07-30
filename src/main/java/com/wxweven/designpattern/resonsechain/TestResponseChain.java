/**
 * @(#)Test.java, Jul 30, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author wangxw03
 */
public class TestResponseChain {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);


    @Test
    public void testAll() {
        Course course = Course.builder().id(1)
                .name("慕课网设计模式课程")
                .article("慕课网设计模式课程--手记")
                .video("慕课网设计模式课程--视频")
                .build();

        CourseMatcher basicCourseMatcher = new BasicCourseMatcher();
        CourseMatcher articleMatcher = new ArticleMatcher();
        CourseMatcher videoMatcher = new VideoMatcher();

        CourseMatcher.initMatchers(Arrays.asList(basicCourseMatcher, articleMatcher, videoMatcher));
        boolean result = CourseMatcher.getFirstMatcher().match(course);

        LOGGER.info("result={}", result);
    }

    @Test
    public void test() {
        Course course = Course.builder().id(1)
                .name("慕课网设计模式课程")
                .video("慕课网设计模式课程--视频")
                .build();

        CourseMatcher basicCourseMatcher = new BasicCourseMatcher();
        CourseMatcher articleMatcher = new ArticleMatcher();
        CourseMatcher videoMatcher = new VideoMatcher();

        CourseMatcher.initMatchers(Arrays.asList(basicCourseMatcher, articleMatcher, videoMatcher));
        boolean result = CourseMatcher.getFirstMatcher().match(course);

        LOGGER.info("result={}", result);
    }

    @Test
    public void test2() {
        Course course = Course.builder().id(1)
                .name("慕课网设计模式课程")
                .article("慕课网设计模式课程--手记")
                .build();

        CourseMatcher basicCourseMatcher = new BasicCourseMatcher();
        CourseMatcher articleMatcher = new ArticleMatcher();
        CourseMatcher videoMatcher = new VideoMatcher();

        CourseMatcher.initMatchers(Arrays.asList(basicCourseMatcher, articleMatcher, videoMatcher));
        boolean result = CourseMatcher.getFirstMatcher().match(course);

        LOGGER.info("result={}", result);
    }
}