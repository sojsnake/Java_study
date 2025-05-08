package basic.ch17.sec03;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );
        //1. 단계별로 변수에 담아 처리
        
        //1) List<Student>를 Stream<Student>로 변환
        Stream<Student> studentStream = list.stream();

        //2) Student의 score만 추출해서 scoreStream 만들기
        IntStream scoreStream = studentStream
                .mapToInt(s -> s.getScore());

        //이미 studentStream은 사용됨 -> 다시 사용 불가
//        IntStream scoreStream2 = studentStream
//                .mapToInt(student -> student.getScore());

        //3) 평균을 계산(average()) 하고 Optional에서 double 값을 꺼냄
        double avg1 = scoreStream
                .average() //OptionalDouble을 반환
                //없을 경우에 대한 예외 처리
                .orElseThrow(() -> new IllegalStateException("점수가 없음")); //예외 발생시킴
        System.out.println("평균 점수 : " + avg1);

        //파이프라인 스타일(체이닝)
        double avg2 = list.stream()
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0.0);
        System.out.println("평균 점수 : " + avg2);

        //stream 끼리 합치기 : concat 사용
        Stream<Student> studentStream1 = list.stream();
        Stream<Student> studentStream2 = Stream.of(
                new Student("세종", 40),
                new Student("광종", 30)
        );

        Stream<Student> concatStudent = Stream.concat(studentStream1, studentStream2);
        concatStudent.forEach(student -> System.out.println(student));
    }
}
