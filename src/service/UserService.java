package service;

import dao.userDao;
import domain.User;

import java.util.List;

public class UserService {
    private final userDao userDao;

    public UserService(userDao userDao) {
        this.userDao = userDao;
    }

    public User registerUser(String name, String email, String rol) throws Exception {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("El Email no puede estar vacio");
        if (!(rol.equals("REPORTER") || rol.equals("ASSIGNEE") || rol.equals("COORDINADOR")))
            throw new IllegalArgumentException("Rol invalido");

        User user = new User(name,email,rol);
        return userDao.create(user);
    }

    public List<User> listAll() throws Exception {
        return userDao.listAll();
    }

    public User findById(int id) throws Exception {
        return userDao.findById(id);
    }
}
