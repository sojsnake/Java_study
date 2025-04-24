package ch08.sec02;

public class Audiot implements RemoteControl{
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }
}
