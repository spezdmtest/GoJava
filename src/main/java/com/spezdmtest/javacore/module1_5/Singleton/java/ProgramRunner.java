package com.spezdmtest.javacore.module1_5.Singleton.java;

public class ProgramRunner {
    public static void main(String[] args) {
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());
//        System.out.println(ProgramLogger.getProgramLogger().toString());

        ProgramLogger.getProgramLogger().addLogInfo("First log....");
        ProgramLogger.getProgramLogger().addLogInfo("Second log....");
        ProgramLogger.getProgramLogger().addLogInfo("Third log....");

        ProgramLogger.getProgramLogger().showLogFile();


    }
}
