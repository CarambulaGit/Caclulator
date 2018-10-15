package com.example.carambula.caclulator;

public class Utils {
    public static String trace(StackTraceElement[] e) {
        boolean doNext = false;
        for (StackTraceElement s : e) {
            if (doNext) {

                return s.getMethodName();
            }
            doNext = s.getMethodName().equals("getStackTrace");
        }
        return "";
    }
}
