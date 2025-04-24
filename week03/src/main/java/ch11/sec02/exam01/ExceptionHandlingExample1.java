package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = 0;
        try {
            result = data.length();
        } catch (Exception e) {
            System.out.println("Exception 발생");
        }
        System.out.println("문자 수 : " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); //여기서 data로 null이 들어가는 문제
        System.out.println("[프로그램 종료]");
    }
}
