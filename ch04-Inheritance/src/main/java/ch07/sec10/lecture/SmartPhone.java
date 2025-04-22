package ch07.sec10.lecture;

public class SmartPhone extends Product {
    //추상 클래스 상속받아 추상 메서드 구현하기
    @Override
    public void abstMethod() {
        System.out.println("Product 클래스의 abstMethod 오버라이딩한 메소드 호출");
    }
}
