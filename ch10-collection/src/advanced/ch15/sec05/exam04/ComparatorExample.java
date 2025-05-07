package advanced.ch15.sec05.exam04;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        //TreeSet<Fruit> treeSet = new TreeSet<>(new FruitComparator());
        //어떤 기준으로 정렬할 것인지 정해줘야 함. -> FruitComparator 클래스 만들고, 괄호 안에 생성해서 넣어주기
        TreeSet<Fruit> treeSet = new TreeSet<>(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                if(o1.getPrice() < o2.getPrice())
                    return -1; // o1이 o2보다 앞에 오게 함
                else if(o1.getPrice() > o2.getPrice())
                    return 1; // o1이 o2보다 뒤에 오게 함
                else return 0;
                //return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        }); //이렇게 바로 넣어줄 수도 있다.

        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));
        
        for(Fruit f : treeSet){
            System.out.println(f.getName() + " : " + f.getPrice());
        }
    }
}
