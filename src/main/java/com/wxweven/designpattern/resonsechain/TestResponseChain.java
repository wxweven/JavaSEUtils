/**
 * @(#)Test.java, Jul 30, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

import org.junit.Assert;
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

        CourseMatcherChainHandler matcherChainHandler = new CourseMatcherChainHandler();

        CourseMatcherChainHandler matcherChainHandler2 = new CourseMatcherChainHandler();


        matcherChainHandler.initMatchers(Arrays.asList(basicCourseMatcher, articleMatcher, videoMatcher));
        boolean result = matcherChainHandler.doMatch(course);

        matcherChainHandler2.initMatchers(Arrays.asList(basicCourseMatcher, videoMatcher));
        boolean result2 = matcherChainHandler2.doMatch(course);

        LOGGER.info("result={}", result);
        Assert.assertTrue(result);

        LOGGER.info("result2={}", result2);
        Assert.assertTrue(result2);
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

        CourseMatcherChainHandler matcherChainHandler = new CourseMatcherChainHandler();
        matcherChainHandler.initMatchers(Arrays.asList(basicCourseMatcher, articleMatcher, videoMatcher));
        boolean result = matcherChainHandler.getFirstMatcher().match(course);

        CourseMatcherChainHandler matcherChainHandler2 = new CourseMatcherChainHandler();
        matcherChainHandler2.initMatchers(Arrays.asList(basicCourseMatcher, videoMatcher));
        boolean result2 = matcherChainHandler2.doMatch(course);

        LOGGER.info("result={}", result);
        Assert.assertFalse(result);

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

        CourseMatcherChainHandler matcherChainHandler = new CourseMatcherChainHandler();
        matcherChainHandler.initMatchers(Arrays.asList(basicCourseMatcher, articleMatcher, videoMatcher));
        boolean result = matcherChainHandler.getFirstMatcher().match(course);

        LOGGER.info("result={}", result);
        Assert.assertFalse(result);

    }
}