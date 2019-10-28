package com.wxweven.designpattern.resonsechain;

/**
 * @author wxweven
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