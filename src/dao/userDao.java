package dao;
import domain.User;

import java.util.ArrayList;

public interface userDao {
    User create(User user) throws Exception;
    ArrayList<User> listAll() throws Exception;
    User findById(int id) throws Exception;
}
