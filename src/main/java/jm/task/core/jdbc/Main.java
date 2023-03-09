package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.removeUserById(2);
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.cleanUsersTable();
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));


    }
}
