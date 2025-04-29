package ch15.sec02.exam01;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Board> list = new ArrayList<>();

        for(int i=1; i<6; i++){
            Board b = new Board("제목"+i, "내용"+i, "작가"+i);
            list.add(b);
        }
        System.out.println("요소 개수: "+list.size());
        System.out.println();
        System.out.println("3번째 데이터: "+list.get(2));
        System.out.println();


        for(int i=0; i<list.size(); i++){
            System.out.println((i+1)+"번째 데이터: "+list.get(i));
        }

        System.out.println();
        list.remove(2);
        for(Board b : list){
            System.out.println(b);
        }

    }
}
