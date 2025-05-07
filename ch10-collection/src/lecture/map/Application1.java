package lecture.map;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /*
        * Map
        * -> Collection 인터페이스들과는 다른 저장 방식
        * key, value 쌍으로 저장하는 방식
        *
        * key란?
        * - 값을 찾기 위한 이름 역할의 객체
        * - 키는 중복을 허용하지 않음, 키가 다르면 중복되는 값은 저장 가능
        * */

        HashMap<String, String> hashMap = new HashMap();

        hashMap.put("1", "java8");
        hashMap.put("2", "oracle");
        hashMap.put("3", "jdbc");
        hashMap.put("4", "jdbc");
//        hashMap.put("4", "j"); 키는 중복저장되지 않고, 최근 키의 value로 덮어씌워짐

        System.out.println("hashMap : " + hashMap);
        hashMap.remove("1");

        //getOrDefault(key, DefaultValue)

        //Iterator로 key value 출력
        System.out.println("===================set을 이용해 Iterator로 변환=======================");
        Set<String> keys = hashMap.keySet();
        Iterator<String> keyIter = keys.iterator(); // iterator() -> iterator 객체 반환
        while(keyIter.hasNext()){
            String key = keyIter.next();
            String value = hashMap.get(key);
            System.out.println(key+" = "+value);
        }

        System.out.println("===================set을 이용해 forEach로 변환=======================");
        for(String key: keys){
            String value = hashMap.get(key);
            System.out.println(key+" = "+value);
        }

        System.out.println("=====================Map 내부의 EntrySet 이용===========================");
        //entrySet() : Map에 저장된 key와 value 쌍을 Set 형태로 "뷰"로 반환
        //-> 이때 반환된 Set은 Map이랑 연결되어 있어서 추가 수정 삭제를 하면 원본에도 반영
        //Set<Map.Entry<K, V>> set = map.entrySet();
        Set<Map.Entry<String,String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> entryIter = set.iterator(); //set이면 iterator 사용 가능
        while(entryIter.hasNext()){
            Map.Entry<String, String> entry = entryIter.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
