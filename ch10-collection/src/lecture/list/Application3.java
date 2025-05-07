package lecture.list;

import java.util.LinkedList;
import java.util.Queue;

public class Application3 {
    public static void main(String[] args) {
        /*
        * Queue
        * - 선형 메모리 공간에 데이터를 저장하는 선입선출(FIFO) 방식의 자료구조
        * - 자체가 인터페이스이기 때문에 인스턴스 생성이 불가
        * */
        Queue<String> queue = new LinkedList<>();

        //데이터 넣을 때 offer()
        queue.offer("first");
        queue.offer("second");
        queue.offer("thied");
        queue.offer("fourth");
        queue.offer("fifth");
        System.out.println("queue = " + queue);
        
        /*
        * peek(): 큐에 가장 앞에 있는 요소 반환
        * poll(): 가장 앞에 있는 요소 반환 후 제거
        * */
        System.out.println("peek() : " + queue.peek());
        System.out.println("queue : " + queue);

        System.out.println("poll() : " + queue.poll());
        System.out.println("queue : " + queue);
    }
}
