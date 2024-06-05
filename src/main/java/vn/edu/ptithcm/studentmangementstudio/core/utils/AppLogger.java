package vn.edu.ptithcm.studentmangementstudio.core.utils;

public class AppLogger {

    public static void log(String message) {
        System.out.println("[AppLog] " + message);
    }

    public static void log(String message, String tag) {
        System.out.println("[" + tag + "] " + message);
    }
}
