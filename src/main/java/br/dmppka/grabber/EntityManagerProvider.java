package br.dmppka.grabber;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static final EntityManager entityManager = Persistence
            .createEntityManagerFactory("EM")
            .createEntityManager();


    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
