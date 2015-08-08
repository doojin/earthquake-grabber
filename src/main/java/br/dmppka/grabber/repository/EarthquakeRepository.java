package br.dmppka.grabber.repository;

import br.dmppka.grabber.EntityManagerProvider;
import br.dmppka.usgsgrabber.model.Earthquake;

import javax.persistence.EntityManager;
import java.util.List;

public class EarthquakeRepository {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public void saveEarthquakes(List<Earthquake> earthquakes) {
        entityManager.getTransaction().begin();
        for (Earthquake earthquake : earthquakes) {
            entityManager.persist(earthquake);
        }
        entityManager.getTransaction().commit();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
