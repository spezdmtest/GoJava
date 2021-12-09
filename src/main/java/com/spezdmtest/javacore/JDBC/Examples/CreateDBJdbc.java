package com.spezdmtest.javacore.JDBC.Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBJdbc {
    static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_TUTORIALS";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String USER = "spezdm";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Registration JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Connection to DB ...");
            connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

            System.out.println("Creating database...");
            statement = connection.createStatement();

            String SQL = "CREATE DATABASE PROSELYTE_JDBC_DB";
            statement.executeUpdate(SQL);
            System.out.println("Database successfully created.....");
        } finally {
            if(statement != null) {
                statement.close();
            }

            if(connection != null) {
                connection.close();
            }
        }
    }
}
