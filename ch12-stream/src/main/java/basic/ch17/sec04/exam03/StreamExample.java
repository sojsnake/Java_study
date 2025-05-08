package basic.ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum;

    /*
    * 순수함수와 부수효과
    * - 순수합수: 입력만으로 결과가 정해지고 외부 상태를 변경하지 않는 함수
    *
    * - 부수효과: 함수나 메서드가 리턴 값 이외에 외부 상태를 변경하는 행위
    *
    * stream을 사용할 땐 순수함수 형태로 사용하는 것이 좋다.
    * */

    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1, 100).parallel();
        //parallel : 병렬처리
        stream.forEach(i -> sum+=i);
        System.out.println("총합 : " + sum);
    }
}
