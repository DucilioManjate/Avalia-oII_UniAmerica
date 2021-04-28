package br.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static  Connection getConnection(){
        Connection connection = null;

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/prova", "root", "secret");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
