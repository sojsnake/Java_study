package ch18.sec03.exam03;

import java.io.*;

public class CopyExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        try(
                InputStream is = new FileInputStream("C:/Temp/test.jpg");
                OutputStream os = new FileOutputStream("C:/Temp/test2.jpg");
                ){
            byte[] data = new byte[1024];

            while(true){
                int num = is.read();
                if(num == -1)
                    break;
                os.write(data, 0, num);
            }
            os.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
