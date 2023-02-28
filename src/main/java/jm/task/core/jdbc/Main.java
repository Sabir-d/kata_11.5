package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Dadashev","Sabir", (byte) 29);
        userService.saveUser("Dadashev","Sabir", (byte) 29);
        userService.saveUser("Dadashev","Sabir", (byte) 29);
        userService.saveUser("Dadashev","Sabir", (byte) 29);
        userService.getAllUsers().forEach(user -> System.out.println("ID =" +user.getId()+" name = "+user.getName()+" nameLast = "+user.getLastName()+" age = "+user.getAge()));
        userService.removeUserById(2);
        userService.getAllUsers().forEach(user -> System.out.println("ID =" +user.getId()+" name = "+user.getName()+" nameLast = "+user.getLastName()+" age = "+user.getAge()));
        userService.cleanUsersTable();
        userService.getAllUsers().forEach(user -> System.out.println("ID =" +user.getId()+" name = "+user.getName()+" nameLast = "+user.getLastName()+" age = "+user.getAge()));


    }
}
