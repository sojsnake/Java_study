package basic.lecture;

public class CharAtExample {
    public static void main(String[] args) {
//        charAt(index)
//        문자열의 지정한 인덱승에 해당하는 문자 하나를 반환
//        (char 타입으로 반환)
        String ssn = "95064589540";
        char gender = ssn.charAt(6);

        System.out.println(gender);
    }
}
