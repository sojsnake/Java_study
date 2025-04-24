package lecture.exception.section02.exception;

/*
* 사용자 정의 예외 클래스
*
* 사전에 정의된 예외클래스 외에 개발자가 원하는 명칭의 예외 클래스를 만들어 작성 가능하다.
* */

public class NotEnoghMoneyException extends Exception {
    public NotEnoghMoneyException() {
    }

    public NotEnoghMoneyException(String message) {
        super(message);
        //부모쪽에 전달해야 메시지 호출 가능
    }
}
