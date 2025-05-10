package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        byte[] data;
        try(
                InputStream is = new FileInputStream("c:/temp/test2.db");
                ){
            data = new byte[100];
            while(true){
                int num = is.read(data); //배열 data에 읽어온 값 넣고, 읽은 수 리턴
                if(num == -1)
                    break;

                for(int i=0;i<num;i++) {
                    System.out.println(data[i]);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
