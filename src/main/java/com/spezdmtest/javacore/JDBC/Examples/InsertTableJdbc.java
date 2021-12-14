package com.spezdmtest.javacore.JDBC.Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTableJdbc {
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

            System.out.println("Creating connection to database... ");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Insert data in table...");
            statement = connection.createStatement();

            String SQL1 ="INSERT INTO developers VALUES (1, 'Prosylyte', 'Java', 3000)";
            statement.executeUpdate(SQL1);
            String SQL2 ="INSERT INTO developers VALUES (2, 'AsyaSmile', 'UI/UX', 2500)";
            statement.executeUpdate(SQL2);
            String SQL3 = "INSERT INTO developers VALUES (3, 'Peter', 'C++', 3000)";
            statement.executeUpdate(SQL3);

            System.out.println("Insert in table successfully...");

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
