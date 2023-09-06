package com.example.restwithroles.database.repository;

import com.example.restwithroles.database.entity.ApiRole;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiRoleRepository {
    private final EntityManager entityManager;

    @Autowired
    public ApiRoleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ApiRole getRole(int id) {
        return entityManager.find(ApiRole.class, id);
    }
}
