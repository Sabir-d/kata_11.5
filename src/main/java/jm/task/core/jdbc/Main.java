package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.createUsersTable();
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.saveUser("Dadashev", "Sabir", (byte) 29);
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.removeUserById(2);
        System.out.println( userService.getAllUsers());
        userService.cleanUsersTable();
        userService.getAllUsers().forEach(user -> System.out.println(user.toString()));
        userService.dropUsersTable();





    }
}
