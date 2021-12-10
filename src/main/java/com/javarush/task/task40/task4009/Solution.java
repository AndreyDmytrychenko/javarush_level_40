package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("16.10.1987", "2021"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdayDate = LocalDate.parse(birthday, dtf);

        Year yearDate = Year.parse(year, DateTimeFormatter.ofPattern("y"));

        return birthdayDate.withYear(yearDate.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.getDefault()));
    }
}
