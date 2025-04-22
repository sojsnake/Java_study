package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        //자식타입 객체 생성
        Child child = new Child();
        
        //부모타입에 child를 업캐스팅
        //자식을 부모 타입으로 형변환
        Parent parent = child; //다형성
//        Parent parent = new Child();
//        기본적으로 부모 것을 가져다 씀. 자식에서 오버라이딩 되었으면, 자식껄로 사용
        
        parent.method1(); //Parent-method1()
        parent.method2(); //Child-method2()
        //parent.method3();
    }

}
