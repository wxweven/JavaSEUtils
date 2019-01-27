/**
 *
 */
package com.wxweven.thread.kongzhongwang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wxweven
 * @date 2014年7月15日
 * @version 1.0
 * @email wxweven@163.com
 * @blog http://wxweven.blog.163.com/
 * @Copyright: Copyright (c) wxweven 2014
 * @Description:
 */
public class Kongzhongwang3 extends Thread {
    public TestDo testDo;
    private String key;
    private String value;

    public Kongzhongwang3(String key, String key2, String value) {
        this.testDo = TestDo.getInstance();

        this.key = key + key2;
        this.value = value;
    }

    public static void main(String[] args) {
        Kongzhongwang3 a = new Kongzhongwang3("1", "", "1");
        Kongzhongwang3 b = new Kongzhongwang3("1", "", "2");
        Kongzhongwang3 c = new Kongzhongwang3("3", "", "3");
        Kongzhongwang3 d = new Kongzhongwang3("4", "", "4");
        Kongzhongwang3 e = new Kongzhongwang3("4", "", "5");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    @Override
    public void run() {
        testDo.doSome(key, value);
    }

    private static class TestDo {
        private static TestDo instance = new TestDo();

        private TestDo() {
        }

        /**
         * 这个是张孝祥老师的解决版本，也比较佩服，扩展性比我的更好
         *
         * @param key
         * @param value
         */

        private Map<String, String> lockMap = new ConcurrentHashMap<>();

        public void doSome(String key, String value) {
            if (!lockMap.containsKey(key)) {
                lockMap.put(key, key);
            }

            synchronized (lockMap.get(key)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(key + ":" + value + "," + (System.currentTimeMillis() / 1000));
            }
        }

        public static TestDo getInstance() {
            return instance;
        }
    }
}