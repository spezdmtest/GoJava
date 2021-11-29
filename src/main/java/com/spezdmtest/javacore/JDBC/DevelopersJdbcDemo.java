package com.spezdmtest.javacore.JDBC;

import java.sql.*;

public class DevelopersJdbcDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_TUTORIALS";

    static final String USER = "spezdm";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver....");
        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Creating databases connection...");
        connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM developers";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from databases... ");
        System.out.println("\nDevelopers:");

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n==============\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
