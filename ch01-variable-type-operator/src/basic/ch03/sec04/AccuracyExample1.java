package basic.ch03.sec04;

public class AccuracyExample1 {
    public static void main(String[] args) {
        // 컴퓨터는 소수를 이진수로 완벽하게 표현이 불가능
        // 근사값을 이용하기 때문에 연산을 여러번하면 오차가 누적됨
//        int apple = 1;
//        double pieceUnit = 0.1;
//        int number = 7;
//
//        double result = apple - number * pieceUnit;
//        System.out.println("result = " + result);

        int apple = 10;
        double pieceUnit = 1;
        int number = 7;

        double result = apple - number * pieceUnit;
        System.out.println("result = " + result/10);
    }
}
