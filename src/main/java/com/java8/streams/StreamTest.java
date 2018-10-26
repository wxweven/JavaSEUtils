package com.java8.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * @author wxweven
 * @date 2018/4/25
 */
public class StreamTest {

    private static List<Integer> numbers = Arrays.asList(1, 2, 3, 6);

    private List<Person> persons;

    @Before
    public void initData() {
        List<String> cities = Arrays.asList("北京", "武汉", "成都", "武汉", "上海");

        persons = IntStream.range(0, 5)
                           .boxed()
                           .map(i -> {
                               Person p = new Person();
                               p.setName("person" + i);
                               p.setAge(i);
                               p.setCity(cities.get(i));

                               return p;
                           })
                           .collect(toList());
    }

    @Test
    public void testMin() {
        int min = numbers.stream()
                         .mapToInt(i -> i)
                         .min()
                         .orElse(0);
        System.out.println(min);
    }

    @Test
    public void testMax() {
        int max = numbers.stream()
                         .mapToInt(i -> i)
                         .max()
                         .orElse(100);
        System.out.println(max);
    }

    @Test
    public void testGougu() {
        IntStream.rangeClosed(1, 100)
                 .boxed()
                 .flatMap(a -> IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                 .limit(5)
                 .forEach(arr -> System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]));


//        IntStream.rangeClosed(1, 100)
//                 .boxed()
//                 .flatMap(a -> IntStream.rangeClosed(1, 100)
//                                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                                        .boxed()
//                                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//                 )
////                 .limit(5)
//                 .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    @Test
    public void testGougu2() {
        IntStream.rangeClosed(1, 100)
                 .boxed()
                 .flatMap(a -> IntStream.rangeClosed(1, 100)
                                        .boxed()
                                        .map(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                        .filter(arr -> arr[2] % 1 == 0)
                 )
                 .limit(5)
                 .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    @Test
    public void testToMap() {
        Map<String, Person> personMap = persons.stream()
                                               .collect(toMap(Person::getName, Function.identity(), (v1, v2) -> v2, LinkedHashMap::new));

        System.out.println(personMap);
    }

    @Test
    public void testGroupingBy() {
        Map<String, List<Person>> listMap = persons.stream()
                                                   .collect(groupingBy(Person::getCity));

        System.out.println(listMap);
    }
}
