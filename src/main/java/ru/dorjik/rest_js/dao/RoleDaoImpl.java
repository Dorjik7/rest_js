package ru.dorjik.rest_js.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dorjik.rest_js.models.Role;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDaoImpl implements  RoleDao{

    private final EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

@Override
   public  Set<Role> getRoles(Long[] userRoles){
        return (Set<Role>) entityManager.createQuery("select r from  Role r  where r.id in(:userRoles)").setParameter("userRoles", Arrays.asList(userRoles)).getResultStream().collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public void initRoles(){

        entityManager.persist(new Role("ROLE_ADMIN"));
        entityManager.persist(new Role("ROLE_USER"));
    }

}
