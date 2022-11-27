package ru.dorjik.rest_js.dao;

import ru.dorjik.rest_js.models.Role;

import java.util.Set;

public interface RoleDao {

    Set<Role> getRoles(Long[] userRoles);

    void initRoles();
}
