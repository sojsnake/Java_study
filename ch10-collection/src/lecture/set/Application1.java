package lecture.set;

import java.util.HashSet;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /*
        * Set 인터페이스 구현
        * - 요소의 저장 순서를 유지하지 않음
        * - 같은 요소의 중복 저장을 허용하지 않음(null 값도 중복 X)
        * */

        HashSet<String> hset = new HashSet<>();
        Set<String> set = new HashSet<>();

        hset.add("java");
        hset.add("mysql");
        hset.add("jdbc");
        hset.add("html");
        hset.add("css");
        System.out.println("hset : " + hset);

        //중복 허용 X
        hset.add("java");
        System.out.println("hset : " + hset);

        //toArray() : 배열로 바꾸고 for문 사용 가능
        Object[] arr = hset.toArray();
        for(int i=0; i<arr.length; i++){
            System.out.println(i+" : " + arr[i]);
        }

        //remove: 삭제 후 성공하면 true, 실패하면 false
        Boolean result = hset.remove("oracle");
        System.out.println("result : " + result);

        hset.clear();
        System.out.println("hset : " + hset);
    }
}
