package br.dmppka.grabber.repository;

import br.dmppka.grabber.TestUtils;
import br.dmppka.grabber.repository.EarthquakeRepository;
import br.dmppka.usgsgrabber.model.Earthquake;
import br.dmppka.usgsgrabber.model.Location;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EarthquakeRepositoryIntegrationTest {

    private EarthquakeRepository earthquakeRepository;

    @Before
    public void setUp() {
        TestUtils.resetDb();
        earthquakeRepository = new EarthquakeRepository();
        earthquakeRepository.setEntityManager(TestUtils.getEntityManager());
    }

    @Test
    public void saveEarthquakes_shouldSaveEarthquakeListToDatabase() {
        // Earthquake 1
        Location location1 = new Location();
        location1.setLatitude(1.1);
        location1.setLongitude(1.2);
        Earthquake earthquake1 = new Earthquake();
        earthquake1.setLocation(location1);
        earthquake1.setId("eq1");
        earthquake1.setMagnitude(1.3);
        Calendar time1 = Calendar.getInstance();
        time1.set(2011, Calendar.JANUARY, 1, 11, 11, 11);
        earthquake1.setTime(time1);

        // Earthquake 2
        Location location2 = new Location();
        location2.setLatitude(2.1);
        location2.setLongitude(2.2);
        Earthquake earthquake2 = new Earthquake();
        earthquake2.setLocation(location2);
        earthquake2.setId("eq2");
        earthquake2.setMagnitude(2.3);
        Calendar time2 = Calendar.getInstance();
        time2.set(2012, Calendar.FEBRUARY, 2, 22, 22, 22);
        earthquake2.setTime(time2);

        List<Earthquake> earthquakesToSave = newArrayList(earthquake1, earthquake2);
        earthquakeRepository.saveEarthquakes(earthquakesToSave);

        String query = "SELECT e FROM Earthquake e";
        TestUtils.getEntityManager().getTransaction().begin();
        List<Earthquake> allEarthquakes = TestUtils.getEntityManager().createQuery(query).getResultList();
        TestUtils.getEntityManager().getTransaction().commit();

        Earthquake eq1 = allEarthquakes.get(0);
        Earthquake eq2 = allEarthquakes.get(1);

        assertThat(allEarthquakes.size(), equalTo(2));

        // Verify earthquake 1
        assertThat(eq1.getId(), equalTo("eq1"));
        assertThat(eq1.getMagnitude(), equalTo(1.3));
        assertThat(eq1.getTime().get(Calendar.YEAR), equalTo(2011));
        assertThat(eq1.getTime().get(Calendar.MONTH), equalTo(Calendar.JANUARY));
        assertThat(eq1.getTime().get(Calendar.DAY_OF_MONTH), equalTo(1));
        assertThat(eq1.getTime().get(Calendar.HOUR_OF_DAY), equalTo(11));
        assertThat(eq1.getTime().get(Calendar.MINUTE), equalTo(11));
        assertThat(eq1.getTime().get(Calendar.SECOND), equalTo(11));
        assertThat(eq1.getLocation().getLatitude(), equalTo(1.1));
        assertThat(eq1.getLocation().getLongitude(), equalTo(1.2));

        // Verify earthquake 2
        assertThat(eq2.getId(), equalTo("eq2"));
        assertThat(eq2.getMagnitude(), equalTo(2.3));
        assertThat(eq2.getTime().get(Calendar.YEAR), equalTo(2012));
        assertThat(eq2.getTime().get(Calendar.MONTH), equalTo(Calendar.FEBRUARY));
        assertThat(eq2.getTime().get(Calendar.DAY_OF_MONTH), equalTo(2));
        assertThat(eq2.getTime().get(Calendar.HOUR_OF_DAY), equalTo(22));
        assertThat(eq2.getTime().get(Calendar.MINUTE), equalTo(22));
        assertThat(eq2.getTime().get(Calendar.SECOND), equalTo(22));
        assertThat(eq2.getLocation().getLatitude(), equalTo(2.1));
        assertThat(eq2.getLocation().getLongitude(), equalTo(2.2));

    }

}