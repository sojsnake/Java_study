package ch07.sec03.exam02;

import org.w3c.dom.ls.LSOutput;

public class Phone {
    public String model;
    public String color;

    public Phone(){

    }

//    매개변수 있는 생성자 -> 자식에서 생성 필수
    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.println("Phone(String model, String color) 생성자 실행");
    }

    public void printModel() {
        System.out.println("부모(Phone)에서 model = " + model);
    }
}
