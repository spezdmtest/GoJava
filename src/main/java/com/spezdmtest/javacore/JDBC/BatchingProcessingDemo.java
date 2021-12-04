package com.spezdmtest.javacore.JDBC;

import java.sql.*;

public class BatchingProcessingDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_TUTORIALS";

    static final String USER = "spezdm";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
        connection.setAutoCommit(false);

        statement = connection.createStatement();

        String SQL = "SELECT * FROM developers";
        ResultSet resultSet = statement.executeQuery(SQL);

        System.out.println("Initial developer's table content:");
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            if(name == null) {
                System.out.println("Table is empty.");
                break;
            }
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n==============================");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: " + salary);
            System.out.println("===============================\n");
        }

        SQL = "INSERT INTO developers VALUES (1, 'Prosylyte','Java',3000)";
        statement.addBatch(SQL);
        SQL = "INSERT INTO developers VALUE (2, 'AsyaSmile', 'UI/UX',2500 )";
        statement.addBatch(SQL);
        SQL = "INSERT INTO developers VALUE (3, 'Peter', 'C++', 3000)";
        statement.addBatch(SQL);

        try {
            statement.executeBatch();
            connection.commit();

            SQL = "SELECT * FROM developers";
            resultSet = statement.executeQuery(SQL);

            System.out.println("Final developer's table content: ");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                int salary = resultSet.getInt("Salary");

                System.out.println("\n==============================");
                System.out.println("id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: " + salary);
                System.out.println("=================================\n");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        System.out.println("Thank you.");
    }
}
