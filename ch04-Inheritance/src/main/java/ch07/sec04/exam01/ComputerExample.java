package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.areaCircle(5));
        Computer com = new Computer();
        System.out.println(com.areaCircle(5));
    }
}
