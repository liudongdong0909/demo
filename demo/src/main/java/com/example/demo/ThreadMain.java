package com.example.demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.concurrent.*;

public class ThreadMain {

    public static void main(String[] args) {
        // MonthDay now = MonthDay.now();
        // String format = MonthDay.now().format(DateTimeFormatter.ofPattern("MM-dd"));
        // System.out.println(now);
        // System.out.println(format);
        //
        // String format1 = LocalDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE);
        // System.out.println(format1);
        //
        // YearMonth yearMonth = YearMonth.now();
        // System.out.println(yearMonth);
        // System.out.println(yearMonth.format(DateTimeFormatter.ofPattern("MM/yy")));


        LocalDateTime min = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime max = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        System.out.println(min + "===" + max);

    }
}
