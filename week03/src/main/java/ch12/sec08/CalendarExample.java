package ch12.sec08;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(); // 현재 시간 가져오기

        // 요일 구하기
        String[] weekDays = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        String dayOfWeekStr = weekDays[cal.get(Calendar.DAY_OF_WEEK)];

        // 오전/오후 구하기
        String ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";

        // 시간
        int hour = cal.get(Calendar.HOUR); // 12시간제
        if (hour == 0) hour = 12; // 0시는 12로 표시

        System.out.println(cal.get(Calendar.YEAR) + "년 " +
                (cal.get(Calendar.MONTH) + 1) + "월 " +
                cal.get(Calendar.DAY_OF_MONTH) + "일");

        System.out.println(dayOfWeekStr + " " + ampm);

        System.out.println(hour + "시 " +
                cal.get(Calendar.MINUTE) + "분 " +
                cal.get(Calendar.SECOND) + "초");
    }
}
