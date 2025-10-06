package controller;

import domain.User;
import service.UserService;

import java.util.List;

public class Controller {
    private final UserService userService;
    public Controller(UserService userService){
        this.userService= userService;
    }

    public User registerUser(String name, String email, String rol) throws Exception {
        return userService.registerUser(name,email,rol);
    };
    public List<User> listUsers() throws Exception {
        return userService.listAll();
    }
}
