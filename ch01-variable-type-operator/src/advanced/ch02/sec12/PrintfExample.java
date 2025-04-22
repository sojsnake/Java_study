package advanced.ch02.sec12;

public class PrintfExample {
    public static void main(String[] args) {
        int value = 123;
        System.out.printf("상품의가격:%d원\n",value);
        System.out.printf("상품의가격:%6d원\n",value);
//        너비 6칸, 오른쪽 정렬 (앞에 공백)

        System.out.printf("상품의가격:%-6d원\n",value);
//        너비 6칸, 왼쪽 정렬 (뒤에 공백)

        System.out.printf("상품의가격:%06d원\n",value);
//        너비 6칸, 빈 자리를 0으로 채움

        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이:%8.2f\n", 10, area);

        String name = "홍길동";
        String job = "도적";
        System.out.printf("%3d|%-8s|%8s\n", 1, name, job);
    }
}
