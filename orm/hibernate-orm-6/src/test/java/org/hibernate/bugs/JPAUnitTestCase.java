package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
    }

    @AfterEach
    void destroy() {
        entityManagerFactory.close();
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    void hhh123Test() throws Exception {
        /*
            We need some test data to see the failing behaviour.
            300.000 Entries in Table is enough to see a "huge" increase in persist time.

            Be aware, that the query "current_identity_value()" takes extremely long.
         */
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            // Do stuff...
            DemoEntity demoEntity = new DemoEntity();
            demoEntity.setaSingleCol("Hello World");
            entityManager.persist(demoEntity);

            entityManager.getTransaction().commit();
            entityManager.close();
        });

    }
}
