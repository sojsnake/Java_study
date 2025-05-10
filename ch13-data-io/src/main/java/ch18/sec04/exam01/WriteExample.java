package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {

        try(Writer writer = new FileWriter("test.txt")){
            char a = 'A';
            writer.write(a);

            char b = 'B';
            writer.write(b);

            char[] arr = {'C', 'D', 'E'};
            writer.write(arr);

            // 안 써줘도 close() 호출될 때 자동으로 호출됨
            writer.flush();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
