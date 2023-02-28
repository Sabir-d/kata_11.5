package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private Util util = new Util();


    public void createUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("CREATE TABLE  user(id INT  PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), lastName VARCHAR(45),age INT)");
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            System.out.println("Таблица существует");
        }
    }

    public void dropUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE user");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("INSERT INTO user (name , lastName,age) VALUES (? , ?,?)")) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.execute();
            System.out.println("Запись добавлена");
        } catch (SQLException e) {
            System.out.println("Не удалось добавить запись");
        }

    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("DELETE  from user where id = ?")) {
            preparedStatement.setLong(1,id);
            preparedStatement.execute();
            System.out.println("Пользователь удален");
        } catch (SQLException e) {
            System.out.println("Пользователь не удален");
        }

    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * from user");
            while (resultSet.next()) {
                User user = new User();
                user.setId((long) resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge((byte) resultSet.getInt(4));
                userList.add(user);
            }
            System.out.println("Лист создан");
        } catch (SQLException e) {
            System.out.println("Лист не создан");
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("DELETE  from user ");
            System.out.println("Пользователи удален");
        } catch (SQLException e) {
            System.out.println("Пользователи не удален");
        }

    }
}
