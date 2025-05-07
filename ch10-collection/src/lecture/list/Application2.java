package lecture.list;

import java.util.Stack;

public class Application2 {
    public static void main(String[] args) {
        /*
        * Stack
        * 선형 메모리 공간에 데이터를 저장하며 후입 선출 방식의 자료구조
        * */
        Stack<Integer> integerStack = new Stack<>();
        //stack에서는 add 보다 push 사용이 권장됨.
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        System.out.println(integerStack);

        //search(순서): 요소를 찾을 때 사용 -> 1부터 시작
        System.out.println("integerStack.search(5) : " + integerStack.search(5));
        
        //peek() 가장 상단에 있는 요소 반환
        //pop() 가장 상단에 있는 요소 반환 후 제거
        System.out.println("peek() : " + integerStack.peek());
        System.out.println(integerStack);

        System.out.println("pop() : "+integerStack.pop());
        System.out.println(integerStack);

    }
}
