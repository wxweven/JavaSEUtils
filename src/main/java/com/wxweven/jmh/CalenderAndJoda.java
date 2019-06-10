package com.wxweven.jmh;

import org.joda.time.DateTime;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class CalenderAndJoda {

    private static final int millis = 24 * 3600 * 1000;

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(CalenderAndJoda.class.getName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(2)
                .build();
        new Runner(options).run();
    }

    @Benchmark
    @Threads(5)
    public void runCalendar() {
        Calendar calendar = Calendar.getInstance();
    }

    @Benchmark
    @Threads(5)
    public void runJoda() {
        DateTime dateTime = new DateTime();
    }

    @Benchmark
    @Threads(5)
    public void runSystem() {
        long result = System.currentTimeMillis() / millis;
    }
}