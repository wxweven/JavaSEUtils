package com.wxweven.jvm.javap.collectiontest;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wxweven
 * @date 2019/6/2
 */
public class CollectionTest {

    public void hello(ArrayList<String> list) {
        System.out.println("list");
    }

    public void hello(Collection<String> collection) {
        System.out.println("collection");
    }

    public static void main(String[] args) {
        /*CollectionTest test = new CollectionTest();
        Collection<String> c = new ArrayList<>();
        test.hello(c);*/

        FatherTest test = new FatherTest();
        test.method1();
        test.method2();

        SonTest test2 = new SonTest();
        test2.method1();
        test2.method2();
    }
}
