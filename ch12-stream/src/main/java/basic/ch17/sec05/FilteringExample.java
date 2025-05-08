package basic.ch17.sec05;

import java.util.*;
import java.util.stream.Stream;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("신용권");
        list.add("신민철");

        Stream<String> stream = list.stream();
        //중복 요소 제거
        stream.distinct().forEach(name -> System.out.println(name));
        System.out.println();

        //신으로 시작하는 요소만 필터링
        Stream<String> stream2 = list.stream();
        stream2.filter(n -> n.startsWith("신"))
                .forEach(name -> System.out.println(name));
        System.out.println();


        //중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
        Stream<String> stream3 = list.stream();
        stream3.distinct().filter(n -> n.startsWith("신"))
                .forEach(name -> System.out.println(name));
    }
}
