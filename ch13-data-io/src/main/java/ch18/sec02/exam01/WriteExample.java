package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {

        try {
            OutputStream fo = new FileOutputStream( "c:/temp/test1.db");
            byte a = 10;
            byte b = 20;
            byte c = 30;

            fo.write(a);
            fo.write(b);
            fo.write(c);

            fo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
