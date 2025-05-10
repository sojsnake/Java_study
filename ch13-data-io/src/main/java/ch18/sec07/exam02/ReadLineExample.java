package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineExample {
    public static void main(String[] args) {
        //파일을 라인 단위로 읽기-> BufferedReader 필요
        try(
                BufferedReader br = new BufferedReader(new FileReader("c:/temp/test3.txt"));
        ){
            int lineNo = 1;
            while(true){
                String str = br.readLine();
                if(str == null) break;
                System.out.println(lineNo+"\t"+str);
                lineNo++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
