package ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        //부모에 자식을 넣음 업캐스팅
        Child parent = new Child();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();
        parent.field2 = "data2";
        //자식꺼 쓸 수 없음
        parent.method3();
        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();
    }

}
