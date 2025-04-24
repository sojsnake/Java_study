package ch12.sec08;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.mm.dd hh:mm:ss");
        String date = now.format(formatter);
        System.out.println(date);
    }
}
