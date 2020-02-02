package com.wxweven.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class DistinctBenchmark {

    @Param({"1000", "10000", "100000"})
    private int length;

    private List<TestData> users;

    @Benchmark
    public void distinct1() {
        DistinctUtils.distinct1(users);
    }

    @Benchmark
    public void distinct2() {
        DistinctUtils.distinct2(users);
    }

    @Setup
    public void prepare() {
        users = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            TestData user = new TestData();
            user.setId(i);
            user.setName(i + "");
            users.add(user);
        }

        for (int i = 1; i <= length; i++) {
            TestData user = new TestData();
            user.setId(i);
            user.setName(i + "");
            users.add(user);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(DistinctBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(2)
                .output("/Users/wxweven/Benchmark2.log")
                .result("result.json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(options).run();
    }
}