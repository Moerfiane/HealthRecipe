package org.launchcode.health_recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

public class CreateMySQLDatabase {
    public static void main(String[] args) {
        // Defines the JDBC URL.
//        // This is a JawsDB hosted on AmazonAWS, care of Michael Banvard. He's willing to keep
//        // it up for a while, to keep things moving forward.
//        String url = "jdbc:mysql://spyd1o2a1ywz4gbx:kdikqyzoq9kbmlro@qn66usrj1lwdk1cc.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/zjn0rnwkv03hnqw6?serverTimezone=UTC";
//
//        // Defines username and password to connect to database server.
//        String username = "spyd1o2a1ywz4gbx";
//        String password = "kdikqyzoq9kbmlro";

        // This is a ClearDB hosted on AmazonAWS, care of Michael Banvard.
        String url = "jdbc:mysql://jdbc:mysql://www.cleardb.com/database/details?id=0A30CBF9C827CB84EC09A18B40740747?serverTimezone=UTC";

        // Defines username and password to connect to database server.
        String username = "b7f364d4f033b1";
        String password = "e5f46ebe";

        // SQL command to create a database in MySQL.
        String sql = "CREATE DATABASE IF NOT EXISTS health_recipe";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
