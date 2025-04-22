package basic.ch02.sec06;

public class StringExample {
    public static void main(String[] args) {
        String name = "홍길동";
        String job = "프로그래머";

        String str = "나는 \"자바\"를 배웁니다.";
        System.out.println("str = " + str);
        
        str = "번호\t이름\t직업";
        System.out.println("str = " + str);
        
        str = "나는 \n자바\n를 배웁니다.";
        System.out.println("str = " + str);
    }
}
