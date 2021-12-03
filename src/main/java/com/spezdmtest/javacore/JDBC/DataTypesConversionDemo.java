package com.spezdmtest.javacore.JDBC;

public class DataTypesConversionDemo {
    public static void main(String[] args) {

        java.util.Date javaDate = new java.util.Date();
        long javaTime = javaDate.getTime();

        System.out.println("Current date and time (Java) " + javaDate.toString());
        System.out.printf("Current time (Java): " + javaDate.getHours()
                                                  + ":" + javaDate.getMinutes()
                                                  + ":" + javaDate.getSeconds());

        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(javaTime);
        java.sql.Date sqlDate = new java.sql.Date(javaTime);
        java.sql.Time sqlTime = new java.sql.Time(javaTime);

        System.out.println("\n====================================\n");
        System.out.println("Current timeStamp (SQL): " + sqlTimeStamp.toString());
        System.out.println("Current date (SQL): " + sqlDate.toString());
        System.out.println("Current time(SQL): " + sqlTime.toString());

    }
}
