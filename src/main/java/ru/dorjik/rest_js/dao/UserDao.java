package ru.dorjik.rest_js.dao;
import ru.dorjik.rest_js.dto.UserDTO;
import ru.dorjik.rest_js.models.User;


import java.util.List;

public interface UserDao {
    void addUser(UserDTO user);

    List<User> userList();

    User getUser(Long id);

    void editUser(Long id, UserDTO user);

    void deleteUser(Long id);

    List<User> findByUsername(String username);
}