/**
 * @(#)ArticleMatcher.java, Jul 30, 2019.
 * <p>
 * Copyright 2019 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.designpattern.resonsechain;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangxw03
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

        CourseMatcher nextMatcher = getNextMatcher();
        if (nextMatcher != null) {
            return nextMatcher.match(course);
        }

        return true;
    }
}