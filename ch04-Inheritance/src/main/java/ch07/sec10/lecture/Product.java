package ch07.sec10.lecture;

public abstract class Product {
    private int nonStaticField;
    private static int StaticField;

    public Product() {
    }
    
//    추상 메서드 1개 이상 필요
    public abstract void abstMethod();
    public void nonStaticMethod(){
        System.out.println("추상클래스안의 nonStaticMethod() 호출됨");
    };
    public static void staticMethod(){
        System.out.println("추상클래스안의 StaticMethod() 호출됨");
    };

}
