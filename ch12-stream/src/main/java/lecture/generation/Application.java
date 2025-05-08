package lecture.generation;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        IntStream intChars = "hello World".chars();
        intChars.forEach(v -> System.out.print(v+" "));
    }
}
