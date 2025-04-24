package ch14.sec03.synchronization;

public class Example {
    public static void main(String[] args) {
//        Account account = new Account();
        SafeAccount account = new SafeAccount();

        //두 스레드가 동시에 출금 시도
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.withdraw(1000);
                System.out.println("Thread 1 출금 후 잔액 : " + account.getBalance());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.withdraw(1000);
                System.out.println("Thread 2 출금 후 잔액 : " + account.getBalance());
            }
        });
        //t1과 t2가 똑같이 접근해서 1000씩 빼도록 함

        t1.start();
        t2.start();
    }
}
