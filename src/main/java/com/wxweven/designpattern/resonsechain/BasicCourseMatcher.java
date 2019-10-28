package com.wxweven.designpattern.resonsechain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wxweven
 */
public class BasicCourseMatcher extends CourseMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicCourseMatcher.class);

    @Override
    protected boolean match(Course course) {
        LOGGER.info("BasicCourseMatcher::match");

        if (course == null) {
            return false;
        }

        CourseMatcher nextMatcher = getMatcherChainHandler().getNextMatcher();
        if (nextMatcher != null) {
            return nextMatcher.match(course);
        }

        return true;
    }
}