package com.spezdmtest.javacore.JDBC.Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SelectDBJdbc {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Europe/Kiev";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String USER = "nexdim";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;

        try {
            System.out.println("Registering JDBC driver.... ");
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to databases");
            connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

            System.out.println("Connection to " + DATABASE_URL + " successfully established.");
        }finally {
            if(connection != null) {
                connection.close();
            }
        }

    }
}
