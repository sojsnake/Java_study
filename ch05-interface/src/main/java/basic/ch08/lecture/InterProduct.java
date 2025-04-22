package basic.ch08.lecture;

public interface InterProduct {
    
    /*
    * 인터페이스는 상수 필드만 작성 가능
    * public static final -> 이 조합을 상수 필드라고 함
    * */
    
    //상수 필드 컴파일러가 자동 생성
    //public static final int a = 0; //초기화 필요
    //묵시적으로 public static final이 숨어있음

    int MIN_NUM = 10;
    int MAX_NUM = 100;

    //인터페이스는
    //1. 생성자를 가질 수 없음
    //public InterProduct() {}

    //2. 일반적인 메서드(구현부가 있는 메서드)도 가질 수 없음
//    public void nonStaticMethod(){}

    //3. static 메서드는 가질 수 있음
    public static void staticMethod(){
        System.out.println("InterProduct 인터페이스에서 staticMethod 호출됨...");
    }

    // 인터페이스에서 일반 메소드를 만들기 위해서는 default 키워드를 붙여야 한다.
    // default는 상속 시 오버라이딩 안해줘도 됨
    public default void defaultMethod(){
        System.out.println("InterProduct 클래스의 defaultMethod 호출됨...");
    }

    //추상 메소드만 작성 가능
    public abstract void nonStaticMethod();
    /*
    * 인터페이스 안에 작성한 메소드는 public abstract의 의미를 가진다.
    * 인터페이스를 상속받은 클래스는 메소드를 구현할 때 접근제어자를
    * public으로 해야지 구현가능함.
    * */
    void abstMethod();
}
