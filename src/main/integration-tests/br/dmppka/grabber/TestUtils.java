package br.dmppka.grabber;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TestUtils {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory("EM-test1env").createEntityManager();

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void resetDb() {
        String clearLocationSQL = "DELETE FROM location";
        String clearEarthquakeSQL = "DELETE FROM earthquake";

        List<String> sqls = newArrayList(
                clearEarthquakeSQL,
                clearLocationSQL
        );

        getEntityManager().getTransaction().begin();
        for (String sql : sqls) {
            getEntityManager().createNativeQuery(sql).executeUpdate();
        }
        getEntityManager().getTransaction().commit();
    }
}
