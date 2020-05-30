/**
 * @(#)AtomicIntegerTest.java, 3月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wxweven.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxweven
 */
@Slf4j
public class AtomicIntegerTest {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final AtomicInteger COUNTER = new AtomicInteger();

    @Test
    public void test() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> add(COUNTER));
        }
        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        System.out.println(COUNTER.get());

        Assert.assertEquals(1000, COUNTER.get());

        COUNTER.set(0);
        Assert.assertEquals(0, COUNTER.get());

    }

    private void add(AtomicInteger counter) {
        counter.addAndGet(10);
    }

    @Test
    public void test2() {
        Map<String, AtomicInteger> channelCounter = new HashMap<>();
        channelCounter.put("gdt", new AtomicInteger());
        channelCounter.put("tt", new AtomicInteger());
        channelCounter.put("wx", new AtomicInteger());

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> multiAdd(channelCounter));
        }

        channelCounter.forEach((channel, counter) -> {
            log.info("channel={}, count={}", channel, counter);
        });

        Assert.assertEquals(100, channelCounter.get("gdt").get());
        Assert.assertEquals(200, channelCounter.get("tt").get());
        Assert.assertEquals(300, channelCounter.get("wx").get());
    }

    private void multiAdd(Map<String, AtomicInteger> channelCounter) {
        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("gdt", 1);
        dataMap.put("tt", 2);
        dataMap.put("wx", 3);

        channelCounter.forEach((channel, counter) -> {
            counter.addAndGet(dataMap.get(channel));
        });
    }
}