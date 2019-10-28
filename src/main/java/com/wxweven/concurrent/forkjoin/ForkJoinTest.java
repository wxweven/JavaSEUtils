package com.wxweven.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ForkJoinPool fjp = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 10);

        // 由于需要返回结果，所以提交到线程池执行，通过future异步的得到执行结果
        Future<Integer> future = fjp.submit(countTask);

        int sum = future.get();
        System.out.println(sum);
    }
}

class CountTask extends RecursiveTask<Integer> {
    // 阈值
    private static final int THRESHOLD = 2;

    // 左指针
    private int start;

    // 右指针
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果任务足够小，就计算
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i < end; i++) {
                sum += i;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(String.format("compute %d~%d = %d", start, end, sum));

        } else {
            // 如果任务大于阈值，接着分割任务
            int middle = (end + start) >> 1;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle, end);

            // 执行子任务
            /**
             * 用下面两个fork是错误的写法，详见https://www.liaoxuefeng.com/article/1146802219354112
             */
            //leftTask.fork();
            //rightTask.fork();

            invokeAll(leftTask, rightTask);

            // 获得子任务的结果
            int leftSum = leftTask.join();
            int rightSum = rightTask.join();

            sum = leftSum + rightSum;
        }

        return sum;
    }

}