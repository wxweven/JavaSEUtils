package com.algorithm.array;

/**
 * @author wxweven
 */
public class PubTest {

    public static void main(String[] args) {
        System.out.println(PubTest.test1());
        System.out.println(PubTest.test2());
    }


    public static int test1() {
        int a = 0;
        try {
            a++;
            return a;
        } finally {
            a++;
        }
    }

    public static int test2() {
        int a = 0;
        try {
            a++;
            return a;
        } finally {
            a++;
            return a;
        }
    }
}