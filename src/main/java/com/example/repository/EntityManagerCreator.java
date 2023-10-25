package com.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerCreator {
    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("com.example.persistence-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }
}
