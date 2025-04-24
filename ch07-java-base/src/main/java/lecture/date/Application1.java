package lecture.date;

import java.util.Calendar;
import java.util.Date;

public class Application1 {
    public static void main(String[] args) {
        //Date 타입의 연도 설정 문제 -> 이제 잘 쓰지 않음
        Date legacyDate = new Date();
        legacyDate.setYear(2025);
        System.out.println("Date setYear(2025) -> 실제출력 : " + legacyDate); //1900이 더해져서 출력됨

        //Calender: 0월부터 시작 -> 잘 쓰지 않음
        Calendar cal = Calendar.getInstance();
        cal.set(2025, 4, 24);
        System.out.println("Calender.set(2025,3,23) -> 실제 월 : " + cal.getTime());
    }
}
