package com.example.apprendejee.DAO.Connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SIngletonConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OrderCraft", "root", "Mohamadera22");
        } catch (Exception e) {
            throw new RuntimeException(e);

        }


    }
    private SIngletonConnection() {
    }
    static public Connection  getConnection (){
        return connection;
    }
}