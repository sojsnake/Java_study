package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for(int i=0; i<=array.length; i++) {
            int value = 0;
            try{
                value = Integer.parseInt(array[i]);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundsException 예외 발생");
            } catch (NullPointerException e){
                System.out.println("NullPointerException 예외 발생");
            } catch (NumberFormatException e){
                //숫자를 문자열 배열에 넣어서 생긴 예외
                System.out.println("NumberFormatException 예외 발생");
            }

            System.out.println("array[" + i + "]: " + value);
        }
    }
}
