package lecture.exception.section01;

public class Application2 {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();

        /*
        * 예외 처리방법
        * -> try-catch 처리
        * */
        //예외 받아서 catch 실행
        try {
            et.checkEnoughMoney(10000, 5000);
            System.out.println("=============상품 구입 가능===================");
        } catch (Exception e) {
            System.out.println("============================================");
        }
        System.out.println("프로그램 종료!");
    }
}
