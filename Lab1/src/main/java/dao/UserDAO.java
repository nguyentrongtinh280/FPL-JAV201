package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    void createUser(User user);
    void updateUser(User user);
    void deleteUser(String userId);
    List<User> getAllUsers();
    User getUserById(String userId);

}
