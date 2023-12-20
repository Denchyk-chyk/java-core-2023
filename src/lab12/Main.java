package lab12;

import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) {
        printInFormat(addTime(LocalDateTime.of(2005, 6,13, 9, 30, 0), Period.of(18, 6, 7)));
        printInFormat(addTime(LocalDateTime.of(2020, 8,18, 12, 20, 0), LocalTime.of(18, 6, 7)));
    }

    private static void printInFormat(LocalDateTime dateTime) {
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd.MM.YY | HH:mm:ss")));
    }

    private static LocalDateTime addTime(LocalDateTime dateTime, Period period) {
        dateTime = dateTime.plusYears(period.getYears());
        dateTime = dateTime.plusMonths(period.getMonths());
        dateTime = dateTime.plusDays(period.getDays());
        return dateTime;
    }

    private static LocalDateTime addTime(LocalDateTime dateTime, LocalTime time) {
        dateTime = dateTime.plusHours(time.getHour());
        dateTime = dateTime.plusMinutes(time.getMinute());
        dateTime = dateTime.plusSeconds(time.getSecond());
        return dateTime;
    }
}