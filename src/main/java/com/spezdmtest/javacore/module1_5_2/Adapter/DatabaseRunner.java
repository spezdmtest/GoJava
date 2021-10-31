package com.spezdmtest.javacore.module1_5_2.Adapter;

public class DatabaseRunner {
    public static void main(String[] args) {
         Database database = new AdapterJavaToDatabase();

         database.insert();
         database.update();
         database.select();
         database.remove();
    }
}
