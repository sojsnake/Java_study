package lecture;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pharmacy> pharmacies = PharmacyCsvReader.readCsv("약국목록.csv");

//        for(Pharmacy p : pharmacies){
//            System.out.println(p);
//        }

        //stream으로 풀어보자
        // 경기에 위치한 약국 걸러내기
        // 전화번호 필드가 빈 약국만 걸러내기
        // 개설 날짜가 2025년도인 약국만 조회하기
        List<Pharmacy> filteredPharmacy = pharmacies.stream()
                .filter(p -> "310000".equals(p.getCityCode()))
                .filter(p -> p.getPhone().isBlank())
                .filter(p -> p.getOpenDate() != null && p.getOpenDate().startsWith("2025"))
                .toList();
        System.out.println(filteredPharmacy.toArray().length);
    }
}