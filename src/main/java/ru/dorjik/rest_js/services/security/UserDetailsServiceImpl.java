package ru.dorjik.rest_js.services.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dorjik.rest_js.dao.UserDao;
import ru.dorjik.rest_js.models.User;

import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public AccountDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = userDao.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new AccountDetails(user.get(0));
    }
}

