package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Coin> c = new Stack<>();
        c.add(new Coin(100));
        c.add(new Coin(50));
        c.add(new Coin(500));
        c.add(new Coin(10));

        while(!c.isEmpty()){
            System.out.println(c.pop());
        }
    }
}
