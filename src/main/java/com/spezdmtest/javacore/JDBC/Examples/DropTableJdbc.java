package com.spezdmtest.javacore.JDBC.Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableJdbc {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/PROSELYTE_JDBC_DB?serverTimezone=Europe/Kiev";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String USER = "nexdim";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

            System.out.println("Removing table in selected database...");
            statement = connection.createStatement();

            String SQL = "DROP TABLE developers";

            statement.executeUpdate(SQL);
            System.out.println("Table successfully removed...");
        }finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}
