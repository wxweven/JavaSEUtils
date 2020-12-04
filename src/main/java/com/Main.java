/**
 * @(#)Main.java, 12月 02, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com;

import java.util.Arrays;

/**
 * @author wxweven
 */
public class Main {

    public static void main(String[] args) {
        Arrays.stream(args).forEach(System.out::println);
    }
}