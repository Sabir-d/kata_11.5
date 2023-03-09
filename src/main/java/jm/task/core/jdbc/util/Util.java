package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Util {

    private final static  String url = "jdbc:mysql://localhost/user";
    private final static String username = "root";
    private final static String password = "root";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Util() {

        try {
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("подключение созданно");
        } catch (SQLException e) {
            System.out.println("Не удалось создать соединение");

        }

    }
}

