package com.java8;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author wxweven
 * @date 2018/9/15
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
