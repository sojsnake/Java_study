package ch14.sec03.exam02;

import java.awt.*;

public class RunnableClass implements Runnable{
    @Override
    public void run() {
        //스레드한테 시킬 일
        //Toolkit 도구모음 클래스
        //beep()

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=0; i<5; i++){
            toolkit.beep();

            try{
                Thread.sleep(500); //0.5초
            } catch(Exception e){
                e.printStackTrace(); //예외가 발생한 위치 경로를 알려줌(콘솔에 출력)
            }
        }
    }
}
