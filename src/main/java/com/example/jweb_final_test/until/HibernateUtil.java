package com.example.jweb_final_test.until;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
 private static final EntityManagerFactory entityManagerFactory = initEntity();

    private static EntityManagerFactory initEntity() {
        return Persistence.createEntityManagerFactory("CFG");
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
