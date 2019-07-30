package com.wxweven.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class FirstBenchmark {

    @Param({"1000", "10000", "100000"})
    private int length;

    private List<Integer> l;

    @Benchmark
    public void streamAdd() {
        Set<Integer> s1 = new HashSet<>();
        l.stream().forEach(li -> s1.add(li));
    }

    @Benchmark
    public void parallelStreamAdd() {
        Set<Integer> s1 = new ConcurrentSkipListSet<>();
        l.parallelStream().forEach(li -> s1.add(li));
    }

    @Benchmark
    public void setNew() {
        Set<Integer> s1 = new HashSet<>(l);
    }

    @Setup
    public void prepare() {
        l = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            l.add(i);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(FirstBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(2)
//                .output("/Users/wxweven/Benchmark.log")
                .result("result.json")
                .resultFormat(ResultFormatType.JSON)
                .build();
        new Runner(options).run();
    }
}