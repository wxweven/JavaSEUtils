package com.wxweven.disruptors;/** * Created with IntelliJ IDEA. Project: test-jar Author: Kevin Date: * 16/5/24 Time: 上午10:39 */public class FalseSharing implements Runnable {	public final static int NUM_THREADS = 4; // change the val of threads	public final static long ITERATIONS = 500L * 1000L * 1000L;	private final int arrayIndex;	private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];	static {		for (int i = 0; i < longs.length; i++) {			longs[i] = new VolatileLong();		}	}	public FalseSharing(final int arrayIndex) {		this.arrayIndex = arrayIndex;	}	public static void main(final String[] args) throws Exception {		final long start = System.currentTimeMillis();		runTest();		System.out.println("duration = " + (System.currentTimeMillis() - start));	}	private static void runTest() throws InterruptedException {		Thread[] threads = new Thread[NUM_THREADS];		for (int i = 0; i < threads.length; i++) {			threads[i] = new Thread(new FalseSharing(i));		}		for (Thread t : threads) {			t.start();		}		for (Thread t : threads) {			t.join();		}	}	public void run() {		long i = ITERATIONS + 1;		while (0 != --i) {			longs[arrayIndex].value = i;		}	}	public final static class VolatileLong {		public long p1, p2, p3, p4, p5, p6, p7; // comment out  remove cache line padding		public volatile long value = 0L;		public long p8, p9, p10, p11, p12, p13, p14; // comment out remove cache line padding	}	public static String 	 panddingTime = "4 Thread duration = 12077"										  + "2 Thread duration = 7311"										  + "1 Thread duration = 6498";	public static String not_panddingTime = "4 Thread duration = 35680"	                                      + "2 Thread duration = 18745"	                                      + "1 Thread duration = 7274";}