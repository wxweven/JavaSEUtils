package com.algorithm.number;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 区间合并 {

    @Test
    public void test2() {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{2, 6};
        intervals[2] = new int[]{8, 10};
        intervals[3] = new int[]{15, 18};

        int[][] merge = merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int[][] result = new int[intervals.length][2];
        int index = -1;
        int[] prev = null;

        for (int[] interval : intervals) {
            if (prev == null || prev[1] < interval[0]) {
                index++;
                result[index][0] = interval[0];
                result[index][1] = interval[1];
                prev = interval;
            } else if (prev[1] < interval[1]) {
                result[index][1] = interval[1];
                prev[1] = interval[1];
            }
        }

        return  Arrays.copyOf(result, index+1);
    }

    /**
     * 解题思路：https://blog.csdn.net/DERRANTCM/article/details/47120501
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (CollectionUtils.isEmpty(intervals)) {
            return Collections.emptyList();
        }

        List<Interval> sortedIntervals = intervals.stream()
                .sorted(Comparator.comparingInt(i -> i.start))
                .collect(Collectors.toList());

        List<Interval> result = new ArrayList<>();
        Interval prev = null;

        /**
         * 排序后，后一个元素（记为next）的start一定是不小于前一个（记为prev）start的，
         * 对于新添加的区间，如果next.start大于prev.end就说明这两个区间是分开的，要添
         * 加一个新的区间，否则说明next.start在[prev.start, prev.end]内，则只要看
         * next.end是否是大于prev.end，如果大于就要合并区间（扩大）
         */
        for (Interval interval : sortedIntervals) {
            if (prev == null || interval.start > prev.end) {
                prev = interval;
                result.add(interval);
            } else if (prev.end < interval.end) {
                prev.end = interval.end;
            }
        }

        return result;
    }

    @Test
    public void test() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(3, 5));

        List<Interval> result = merge(intervals);
        System.out.println(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(1, result.get(0).start);
        Assert.assertEquals(5, result.get(0).end);

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        result = merge(intervals);
        System.out.println(result);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(1, result.get(0).start);
        Assert.assertEquals(6, result.get(0).end);
        Assert.assertEquals(15, result.get(2).start);
        Assert.assertEquals(18, result.get(2).end);
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
