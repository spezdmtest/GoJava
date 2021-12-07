package com.spezdmtest.javacore.JDBC;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class StreamingDataDemo {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/PROSELYTE_TUTORIALS";

    static final String USER = "spezdm";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database ....");
            conn = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

            stmt = conn.createStatement();
            createXMLTable(stmt);

            File f = new File("/home/spezdm/IdeaProjects/JavaCore/src/main/" +
                    "java/com/spezdmtest/javacore/JDBC/Proselyte_Developer.xml");
            long fileLength = f.length();
            FileInputStream fis = new FileInputStream(f);

            String SQL = "INSERT INTO XML_Developer VALUES (?,?)";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,1);
            pstmt.setAsciiStream(2,fis,(int) fileLength );
            pstmt.execute();

            fis.close();

            SQL = "SELECT Data FROM XML_Developer WHERE id=1";
            rs = stmt.executeQuery(SQL);
            if(rs.next()) {
                InputStream xmlInputStream = rs.getAsciiStream(1);
                int c;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((c = xmlInputStream.read()) != -1)
                    bos.write(c);
                System.out.println(bos.toString());
            }
            rs.close();
            stmt.close();
            pstmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(pstmt != null)
                    pstmt.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            }catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Thank you!");
    }

    public static void createXMLTable(Statement statement) throws SQLException {
        System.out.println("Creating XMl_Developer table...");
        String SQL = "CREATE TABLE XML_Developer " +
                "(id INTEGER, Data LONG)";

        try {
            statement.executeUpdate("DROP TABLE XML_Developer");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        statement.executeUpdate(SQL);
    }
}
