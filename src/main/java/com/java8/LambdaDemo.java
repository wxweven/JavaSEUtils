package com.java8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Lambda Demo
 * Created by wxweven on 2017/3/18.
 */
public class LambdaDemo {
    public static void main(String[] args) {
        int res;
        Converter<String, Integer> converter = a -> {
            System.out.println("函数内部...");
            return Integer.valueOf(a);
        };

        res = converter.convert("456");
        System.out.println("val:" + res);

        Converter<String, Integer> converter2 = Integer::valueOf;
        res = converter2.convert("12");
        System.out.println("val:" + res);

        List<String> l = Stream.of("a", "b", "c", "b")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(l);

    }

    @Test
    public void test() {
        String origStr = "1233aabbcc";

        String str1 = handleStr(origStr, StringUtils::upperCase);
        System.out.println(str1);

        String str2 = handleStr(origStr, StringUtils::lowerCase);
        System.out.println(str2);

        String str3 = handleStr(origStr, str -> str + 456);
        System.out.println(str3);

        String str4 = handleStr(() -> origStr.substring(1, 5));
        System.out.println(str4);
    }

    private String handleStr(String str, Function<String, String> handleFunc) {
        String handleResult = handleFunc.apply(str);
        return handleResult;
    }

    private String handleStr(Supplier<String> getFunc) {
        return getFunc.get();
    }
}
