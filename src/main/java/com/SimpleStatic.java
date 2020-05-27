package com;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxweven on 17/9/5.
 */
public class SimpleStatic {
    public static int id = 1;
    public static int number;

    static {
        number = 2;
    }

    @Test
    public void test() {
        List<Integer> s = Collections.emptyList();
        s.stream().forEach(System.out::println);

        Map<Integer, Integer> res = new HashMap<>();


        res.putAll(Collections.emptyMap());

        System.out.println(res);

    }

    private static int testFinally() {
        int num = 1;
        try {

            return ++num;
        } finally {
            return num++;
        }
    }

    public static void main(String[] args) throws IOException {
//        int i = testFinally();
//        System.out.println(i);

        List list = new ArrayList();

        SimpleStatic simpleStatic = new SimpleStatic();

        simpleStatic.print(list);

        System.in.read();


    }

    public void print(ArrayList arrayList) {
        System.out.println("ArrayList");
    }

    public void print(List list) {
        System.out.println("List");
    }

    public void print(Collection collection) {
        System.out.println("Collection");
    }
}
