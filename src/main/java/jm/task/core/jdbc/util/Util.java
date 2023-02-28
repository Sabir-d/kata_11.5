package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Util {

    private String url = "jdbc:mysql://localhost/user";
    private String username = "root";
    private String password = "root";
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

