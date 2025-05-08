package advanced.ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5};
        Arrays.stream(intArray)
                .mapToDouble(i -> (double) i)
                .forEach(s -> System.out.println(s));

        System.out.println();

        Arrays.stream(intArray)
                .forEach(s -> System.out.println(s));
    }
}
