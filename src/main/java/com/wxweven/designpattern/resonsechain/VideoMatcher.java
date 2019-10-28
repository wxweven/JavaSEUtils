package com.wxweven.designpattern.resonsechain;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wxweven
 */
public class VideoMatcher extends CourseMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoMatcher.class);

    @Override
    protected boolean match(Course course) {
        LOGGER.info("VideoMatcher::match");

        String video = course.getVideo();
        if (StringUtils.isBlank(video)) {
            return false;
        }

        if (StringUtils.length(video) < 5) {
            return false;
        }

        CourseMatcher nextMatcher = getMatcherChainHandler().getNextMatcher();
        if (nextMatcher != null) {
            return nextMatcher.match(course);
        }

        return true;
    }
}