package basic.ch04.sec02;

import java.util.Random;

public class ifDiceExample {
    public static void main(String[] args) {
        // 1~6 사이의 값을 랜덤하게 만들어 보자
        // Math.random: 0.0~1.0미만 난수 반환(double)

        int num = (int) (Math.random() * 6) + 1;
//        6곱해줘서 0.0이상 6.0 미만 난수를 반환하게 됨
//        1~6 나오게 하려면 +1

//      Random 객체 만듦 -> heap에 들어감.
        Random rand = new Random();
//        0~인자로 준 값 미만까지
        num = rand.nextInt(6) + 1;

        if (num == 1) {
            System.out.println("1이 나왔습니다.");
        }else if(num == 2){
            System.out.println("2가 나왔습니다.");
        }else if(num == 3){
            System.out.println("3이 나왔습니다.");
        }else if(num == 4){
            System.out.println("4가 나왔습니다.");
        }else if(num == 5){
            System.out.println("5가 나왔습니다.");
        }else{
            System.out.println("6이 나왔습니다.");
        }
    }
}
