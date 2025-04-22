package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
//        Car myCar = new Car();
//        Car myCar2 = new Car();
//        Car myCar3 = new Car();
//        //Tire 타입의 tire 속성이 정의되지 않음.
//
//        //자식 타입을 부모 타입으로 형변환 - 업캐스팅
//        Tire tire = new Tire();
//        Tire tire2 = new HankookTire();
//        Tire tire3 = new KumhoTire();
//        myCar.tire = tire;
//        myCar2.tire = tire2;
//        myCar3.tire = tire3;
//
//        myCar.run();
//        myCar2.run();
//        myCar3.run();
        Tire[] tires = { new Tire(), new HankookTire(), new KumhoTire() };
        for (Tire tire : tires) {
            Car car = new Car();
            car.tire = tire;
            car.run();
        }
    }
}
