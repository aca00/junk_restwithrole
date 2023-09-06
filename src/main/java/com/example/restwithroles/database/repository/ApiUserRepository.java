package com.example.restwithroles.database.repository;

import com.example.restwithroles.database.entity.ApiUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiUserRepository {
    private final EntityManager entityManager;

    @Autowired
    public ApiUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ApiUser getByName(String name) {
        TypedQuery<ApiUser> query = entityManager.createQuery(
                "from ApiUser where userName=:name",
                ApiUser.class
        );

        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
