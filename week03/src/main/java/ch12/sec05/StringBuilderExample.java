package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF") //DEF 추가
                .insert(0, "ABC") //0번인덱스부터 ABC 넣기 => ABCDEF
                .delete(3, 4) //D 제거. ABCEF
                .toString();
        System.out.println(data);
    }
}
