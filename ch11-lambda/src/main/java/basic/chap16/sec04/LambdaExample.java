package basic.chap16.sec04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        person.action((x, y) -> {
            double result = x+y;
            return result;
        });

//        person.action((x, y) -> sum(x, y));
        
        /*
        * 메소드 참조
        * 함수형 인터페이스를 람다식으로 쓰는 게 아닌, (이미 구현되어 있는) 일반 메소드를 참조시켜 선언하는 방법
        * 일반 메소드를 참조하기 위한 조건
        * : 각 메소드의 매개변수 타입/갯수/반환형이 같아야 함
        * 
        * 사용 방법 
        * static 메서드 일 때
        * -> 클래스 이름::메소드 이름
        * instance 메서드 일 때
        * -> 참조변수이름 :: 메소드 이름
        * */
        person.action(LambdaExample::sum);
    }
    public static double sum(double x, double y){
        return (x+y);
    }
}
