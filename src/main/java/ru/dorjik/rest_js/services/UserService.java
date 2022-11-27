package ru.dorjik.rest_js.services;

import ru.dorjik.rest_js.dto.UserDTO;
import ru.dorjik.rest_js.models.User;

import java.util.List;

public interface UserService {
    void addUser(UserDTO user);

    List<User> listUsers();

    User getUser(Long id);

    void editUser(Long id, UserDTO user);

    void deleteUser(Long id);

}
