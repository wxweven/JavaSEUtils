/**
 * @(#)CourseMatcher.java, Jul 30, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

/**
 * @author wangxw03
 */
public abstract class CourseMatcher {

    public CourseMatcherChainHandler getMatcherChainHandler() {
        return matcherChainHandler;
    }

    public CourseMatcher setMatcherChainHandler(CourseMatcherChainHandler matcherChainHandler) {
        this.matcherChainHandler = matcherChainHandler;
        return this;
    }

    protected CourseMatcherChainHandler matcherChainHandler;

    protected abstract boolean match(Course course);


}