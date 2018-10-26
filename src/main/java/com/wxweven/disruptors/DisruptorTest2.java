package com.wxweven.disruptors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Simple RingBuffer Demo
 * Created by wxweven on 2017/4/22.
 */
public class DisruptorTest2 {
    private static final int RING_BUFFERSIZE = 1 << 10;

    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(10);// 大于consumer的数量

        Disruptor<TestObject> disruptor = new Disruptor<>(
                new TestObjectFactory(),
                RING_BUFFERSIZE,
                executor,
                ProducerType.SINGLE,
                new BusySpinWaitStrategy()
        );

        // //使用disruptor创建消费者AnalysisHandler,CalcHandler，两个可以并行执行
        // EventHandlerGroup<TestObject>
        // handlerGroup=disruptor.handleEventsWith(new
        // TestObjectAnalysisHandler(),new TestObjectCalcHandler());
        //
        // //声明在AnalysisHandler,CalcHandler完事之后执行NotifyHandler
        // EventHandlerGroup<TestObject> then = handlerGroup.then(new
        // TestObjectNotifyHandler());
        //
        // //最终调用多个线程，进行数据的写入
        // then.thenHandleEventsWithWorkerPool(new TestObjectDBHandler(),new
        // TestObjectDBHandler());

        // 上面的也可以直接通过链式调用
        disruptor.handleEventsWith(new TestObjectAnalysisHandler(), new TestObjectCalcHandler())
                 .then(new TestObjectNotifyHandler())
                 .thenHandleEventsWithWorkerPool(new TestObjectDBHandler(), new TestObjectDBHandler());

        disruptor.start();// 启动

        CountDownLatch latch = new CountDownLatch(1);
        // 生产者准备
        executor.submit(new TestObjectPublisher(latch, disruptor));
        latch.await();// 等待生产者完事.
        disruptor.shutdown();
        executor.shutdown();

        System.out.println("总耗时:" + (System.currentTimeMillis() - beginTime));
    }
}
