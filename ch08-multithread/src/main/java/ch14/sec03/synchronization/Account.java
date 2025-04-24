package ch14.sec03.synchronization;

public class Account {
    //공유자원: 여러 스레드가 동시에 접근할 수 있는 데이터(공통으로 사용하는 자원)
    private int balance = 10000;

    public void withdraw(int money){

        //공유 자원을 여러 스레드가 건드릴 수 있는 영역을 임계영역
        //임계영역은 반드시 한 번에 한 스레드만 실행되어야 데이터 꼬임을 방지할 수 있다.
        //=> 동기화로 해결
        if(balance >= money){
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){}
            balance -= money;
        }
    }
    public int getBalance(){
        return balance;
    }
}
