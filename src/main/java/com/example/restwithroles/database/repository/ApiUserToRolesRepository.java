package com.example.restwithroles.database.repository;

import com.example.restwithroles.database.entity.ApiUserToRoles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApiUserToRolesRepository {
    private final EntityManager entityManager;

    @Autowired
    public ApiUserToRolesRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Integer> getRolesFromUserId(int id) {
        List<Integer> roleIds = new ArrayList<>();
        TypedQuery<ApiUserToRoles> query = entityManager.createQuery(
                "from ApiUserToRoles where userId=:id",
                ApiUserToRoles.class
        );
        query.setParameter("id", id);
        List<ApiUserToRoles> apiUserToRoles = query.getResultList();
        for (ApiUserToRoles apiUserToRole : apiUserToRoles) {
            roleIds.add(apiUserToRole.getRoleId());
        }
        return roleIds;
    }
}
