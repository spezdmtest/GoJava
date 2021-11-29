package com.spezdmtest.javacore.JDBC;

import java.sql.*;

public class StatementDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL= "jdbc:mysql://localhost/PROSELYTE_TUTORIALS";

    static final String USER = "spezdm";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");
        Class.forName(JDBC_DRIVER);

        System.out.println("Connection to databases...");
        connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

        System.out.println("Creating statement...");
        statement = connection.createStatement();

        String sql = "SELECT * FROM developers";

        Boolean isRetrieved = statement.execute(sql);

        System.out.println("Is data retrieved: " + isRetrieved);

        System.out.println("Displaying retrieved data: ");
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: " + salary);
            System.out.println("\n=================\n");
        }

        System.out.println("Closing connection and releasing resources...");

        try {
            resultSet.close();
            statement.close();
            connection.close();
        }finally {
            if(statement != null);
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }

        System.out.println("Thank You.");

    }
}
