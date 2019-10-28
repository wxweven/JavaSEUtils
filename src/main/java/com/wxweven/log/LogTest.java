package com.wxweven.log;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author wxweven
 */
public class LogTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.Logger logger = loggerContext.getLogger("com.wxweven");
        Level level = logger.getLevel();

        Level targetLevel = Level.WARN;

        Configurator.setLevel("com.wxweven", targetLevel);

        LOGGER.debug("00000");
        LOGGER.info("11111");
        LOGGER.warn("22222");
        LOGGER.error("33333");


        System.out.println(level);

    }

    @Test
    public void test3() {
        String string = "fsdfds@qq.com";
        String string2 = "fsdfds";


        String s = StringUtils.endsWithIgnoreCase(string, "@qq.com") ? string : string + "@qq.com";
        String s2 = StringUtils.endsWithIgnoreCase(string2, "@qq.com") ? string2 : string2 + "@qq.com";


        System.out.println(s);
        System.out.println(s2);

    }

    @Test
    public void test2() {

        Map<String, String> logLevelConfigMap = new HashMap<>();
        logLevelConfigMap.put("com.wxweven.jvm", "WARNfff");
        logLevelConfigMap.put("com.wxweven.log", "INFO");


        Collection<String> values = logLevelConfigMap.values();

        System.out.println("33333");
        System.out.println("33333");
        System.out.println("333");




        Map<String, String> newMap = logLevelConfigMap.entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, e -> Level.toLevel(e.getValue(), Level.INFO).name()));

        LOGGER.info("map={}", logLevelConfigMap);
        LOGGER.info("newMap={}", newMap);
    }
}