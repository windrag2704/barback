package com.example.barBack.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static LocalDateTime parseDate(String stringDate, boolean haveTime) {
        if (haveTime) {
            return LocalDateTime.parse(stringDate, DATE_TIME_FORMATTER);
        } else {
            LocalDate date = LocalDate.parse(stringDate);
            return date.atStartOfDay();
        }
    }

    public static Timestamp getStartDate(String stringDate, boolean haveTime) {
        return Timestamp.valueOf(parseDate(stringDate, haveTime).with(LocalTime.MIN));
    }

    public static Timestamp getEndDate(String stringDate, boolean haveTime) {
        return Timestamp.valueOf(parseDate(stringDate, haveTime).with(LocalTime.MAX));
    }

    public static Timestamp getDate(String stringDate) {
        LocalDateTime date = LocalDateTime.parse(stringDate, DATE_TIME_FORMATTER);
        return Timestamp.valueOf(date);
    }
}
