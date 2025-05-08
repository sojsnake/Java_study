package basic.ch17.sec01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        System.out.println("-------향상된 for문 사용---------");
        for(String str : set)
            System.out.println(str);

        System.out.println("-------Stream 사용---------");
        Stream<String> stream = set.stream();
        stream.forEach(name -> System.out.println(name));

        System.out.println("----------------");
        set.forEach(name -> System.out.println(name));
        System.out.println("----------------");
        set.stream()
                //.sorted()  //사전순으로 정렬
                .sorted(Comparator.reverseOrder())
                .limit(2) //앞에서부터 크기만큼 자르기
                .forEach(name -> System.out.println(name));
    }
}
