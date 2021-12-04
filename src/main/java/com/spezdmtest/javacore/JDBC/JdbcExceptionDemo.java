package com.spezdmtest.javacore.JDBC;

import java.sql.*;

public class JdbcExceptionDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_TUTORIALS";

    static final String USER = "spezdm";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) {
        Connection connection = null;

    try {
        Class.forName(JDBC_DRIVER);

        System.out.println("Connection to database ...");
        connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

        System.out.println("Creating statement...");
        Statement statement= connection.createStatement();

        String SQL = "SELECT * FROM developers";
        ResultSet resultSet = statement.executeQuery(SQL);

        System.out.println("Displaying retrieved records...");

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n======================");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: " + salary);
            System.out.println("==================\n");
        }

        System.out.println("Releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();

        System.out.println("Thank you");

    }catch (SQLException e) {
        e.printStackTrace();
    }catch (ClassNotFoundException e) {
        e.printStackTrace();
    }finally {
        try {
            if(connection != null) {
                connection.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
            }
        }
    }
}
