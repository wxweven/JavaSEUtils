package com.wxweven.designpattern.resonsechain;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wxweven
 */
public class ArticleMatcher extends CourseMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleMatcher.class);

    @Override
    protected boolean match(Course course) {
        LOGGER.info("ArticleMatcher::match");

        String article = course.getArticle();
        if (StringUtils.isBlank(article)) {
            return false;
        }

        if (StringUtils.length(article) < 10) {
            return false;
        }

        CourseMatcher nextMatcher = getMatcherChainHandler().getNextMatcher();
        if (nextMatcher != null) {
            return nextMatcher.match(course);
        }

        return true;
    }
}