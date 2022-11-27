package ru.dorjik.rest_js.configs;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.dorjik.rest_js.dao.RoleDao;
import ru.dorjik.rest_js.dto.UserDTO;
import ru.dorjik.rest_js.services.UserService;


@Component
public class DefaultUsers implements ApplicationRunner {
    private final UserService userService;
    private final RoleDao roleDao;

    public DefaultUsers(UserService userService, RoleDao roleDao) {
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @Override
    public void run(ApplicationArguments args) {

        if (userService.listUsers().isEmpty()) {
            roleDao.initRoles();
            userService.addUser(new UserDTO("admin", "admin",
                    "Admin", "Admin", 55,
                    "admin@mail.ru", new Long[]{(long) 1}));
            userService.addUser(new UserDTO("user", "user",
                    "User", "User", 22,
                    "user@mail.ru", new Long[]{(long) 2}));
            userService.addUser(new UserDTO("multi", "multi",
                    "Multi", "Multi", 77,
                    "multi@mail.ru", new Long[]{(long) 1, (long) 2}));

        }
    }
}