package com.spezdmtest.javacore.module1_5.Singleton.java;

public class ProgramLogger {
    private static ProgramLogger programLogger;
    private static String logFile = "This is log file.... \n\n";

    public static ProgramLogger getProgramLogger() {
         if(programLogger == null) {
             programLogger = new ProgramLogger();
         }
         return programLogger;
    }

    private ProgramLogger() {

    }

    public void addLogInfo(String logInfo) {
        logFile += logInfo + "\n";
    }

    public void showLogFile() {
        System.out.println(logFile);
    }
}
