package vn.edu.ptithcm.studentmangementstudio.core.utils;

import vn.edu.ptithcm.studentmangementstudio.core.K;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AppFormatter {
    public static String formatDate(LocalDate date) {
        var df = DateTimeFormatter.ofPattern(K.Pattern.DATE);
        return df.format(date);
    }

    public static String formatDate(Date date, String pattern) {
        var df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date parseDate(String date) {
        try {
            var df = new SimpleDateFormat(K.Pattern.DATE);
            return df.parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
