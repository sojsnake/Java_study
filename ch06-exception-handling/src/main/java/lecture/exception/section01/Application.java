package lecture.exception.section01;

public class Application {
    public static void main(String[] args) throws Exception {
        ExceptionTest et = new ExceptionTest();

        /*
        * 예외 처리방법
        * -> try-catch 처리
        * */
        et.checkEnoughMoney(10000, 5000);
    }
}
