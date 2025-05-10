package lecture;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PharmacyCsvReader {

    public static List<Pharmacy> readCsv(String filePath) {
        //list 생성
        List<Pharmacy> pharmacies = new ArrayList<>();

        //list에 데이터 담아주기
        //csv 파일은 문자열 담고 있음
        //BufferedReader -> 보조 스트림

        //이렇게 괄호 안에 쓰면 자동으로 close
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isFirstLine = true;

            while((line = br.readLine()) != null){
                //첫 줄(헤더) 무시
                if(isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] field = parseCsvLine(line);
//                System.out.println("field = " + Arrays.toString(field));

                //일치하지 않거나 누락되면 오류 발생 가능 -> 패스
                if(field.length < 14){
                    System.out.println(" 잘못된 라인 " + line);
                    continue;
                }

                pharmacies.add(new Pharmacy(field));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pharmacies;
    }

    private static String[] parseCsvLine(String line) {
        //""로 묶여있는 데이터는 파싱하지 않도록 해줌
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();
        //열 별로 current에 넣어뒀다가 list에 추가

        //큰 따옴표 만났는지 여부
        boolean inQuotes = false;

        //한 줄 전체 돌면서 확인
        for(int i=0; i<line.length(); i++){
            char c = line.charAt(i);

            //"1,2,3"

            //큰 따옴표 만나면
            if(c == '"'){
                //다시 만나면 false로 바뀌게끔
                inQuotes = !inQuotes;
            } else if(c == ',' && !inQuotes){
                //콤마를 만났을 때 큰 따옴표 내부가 아닌 경우 = 다음 필드의 값으로 넘어갔을 때

                result.add(current.toString().trim());
                //current에 쌓인 문자를 문자열로 바꾸고 공백 제거한 후 result에 추가

                current.setLength(0);
                //문자열로 빼냈으므로 초기화시키기
            } else{
                //그 외 나머지 문자일 때
                current.append(c);
            }
        }

        //마지막 필드 추가
        //current에서 빼내지지 않은 거 있을 때
        result.add(current.toString().trim());

        return result.toArray(String[] :: new);
    }
}
