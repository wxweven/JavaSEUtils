package com.wxweven.disruptors;import com.lmax.disruptor.EventHandler;import com.lmax.disruptor.WorkHandler;/** * Created with IntelliJ IDEA. * Project: test-jar * Author: Kevin * Date: 16/5/24 * Time: 下午8:11 */public class TestObjectDBHandler implements EventHandler<TestObject>,WorkHandler<TestObject>{	@Override	public void onEvent(TestObject event) throws Exception {		//you can save you data in db;		System.out.println("thread: " + Thread.currentThread().getId() + " object: " + event.getValue() + "入库");	}	@Override	public void onEvent(TestObject event, long sequence, boolean endOfBatch) throws Exception {		this.onEvent(event);	}}