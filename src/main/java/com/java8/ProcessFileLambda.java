package com.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wxweven
 * @date 2018/9/15
 */
public class ProcessFileLambda {
    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/wxweven/histo.txt"))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String oneLine = ProcessFileLambda.processFile(BufferedReader::readLine);
        System.out.println(oneLine);

        String twoLines = ProcessFileLambda.processFile(br -> br.readLine() + br.readLine());
        System.out.println(twoLines);
    }
}
