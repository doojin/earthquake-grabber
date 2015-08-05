package br.dmppka.usgsgrabber.converter;

import br.dmppka.usgsgrabber.exception.DateParseException;
import br.dmppka.usgsgrabber.model.Earthquake;
import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static br.dmppka.usgsgrabber.builder.EventBuilder.anEvent;
import static br.dmppka.usgsgrabber.builder.EventParametersBuilder.anEventParameters;
import static br.dmppka.usgsgrabber.builder.LatitudeBuilder.aLatitude;
import static br.dmppka.usgsgrabber.builder.LongitudeBuilder.aLongitude;
import static br.dmppka.usgsgrabber.builder.MagBuilder.aMag;
import static br.dmppka.usgsgrabber.builder.MagnitudeBuilder.aMagnitude;
import static br.dmppka.usgsgrabber.builder.OriginBuilder.anOrigin;
import static br.dmppka.usgsgrabber.builder.TimeBuilder.aTime;
import static br.dmppka.usgsgrabber.builder.USGSXMLResponseBuilder.anUSGSXMLResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class USGSXMLResponseToEarthquakeListConverterTest {

    private Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
    private USGSXMLResponseToEarthquakeListConverter converter =
            new USGSXMLResponseToEarthquakeListConverter();

    @Test
    public void shouldConvertUSGSXMLResponseToListOfEarthquakes() {
        USGSXMLResponse response = anUSGSXMLResponse()
                .withEventParameters(anEventParameters()
                        .withEvents(
                                anEvent()
                                        .withId("Event1")
                                        .withMagnitude(aMagnitude()
                                                .withMag(aMag()
                                                        .withValue(1.1)
                                                        .build())
                                                .build())
                                        .withOrigin(anOrigin()
                                                .withLatitude(aLatitude()
                                                        .withValue(1.1)
                                                        .build())
                                                .withLongitude(aLongitude()
                                                        .withValue(1.1)
                                                        .build())
                                                .withTime(aTime()
                                                        .withValue("2011-01-01T11:11:00.000Z")
                                                        .build())
                                                .build())
                                        .build(),
                                anEvent()
                                        .withId("Event2")
                                        .withMagnitude(aMagnitude()
                                                .withMag(aMag()
                                                        .withValue(2.2)
                                                        .build())
                                                .build())
                                        .withOrigin(anOrigin()
                                                .withLatitude(aLatitude()
                                                        .withValue(2.2)
                                                        .build())
                                                .withLongitude(aLongitude()
                                                        .withValue(2.2)
                                                        .build())
                                                .withTime(aTime()
                                                        .withValue("2012-02-02T22:22:00.000Z")
                                                        .build())
                                                .build())
                                        .build()
                        )
                        .build())
                .build();

        List<Earthquake> earthquakes = mapper.map(response, List.class);

        Earthquake earthquake1 = earthquakes.get(0);
        Earthquake earthquake2 = earthquakes.get(1);

        assertThat(earthquakes.size(), equalTo(2));

        assertThat(earthquake1.getId(), equalTo("Event1"));
        assertThat(earthquake1.getMagnitude(), equalTo(1.1));
        assertThat(earthquake1.getTime().get(Calendar.YEAR), equalTo(2011));
        assertThat(earthquake1.getTime().get(Calendar.MONTH), equalTo(Calendar.JANUARY));
        assertThat(earthquake1.getTime().get(Calendar.DAY_OF_MONTH), equalTo(1));
        assertThat(earthquake1.getTime().get(Calendar.HOUR_OF_DAY), equalTo(11));
        assertThat(earthquake1.getTime().get(Calendar.MINUTE), equalTo(11));
        assertThat(earthquake1.getLocation().getLatitude(), equalTo(1.1));
        assertThat(earthquake1.getLocation().getLongitude(), equalTo(1.1));

        assertThat(earthquake2.getId(), equalTo("Event2"));
        assertThat(earthquake2.getMagnitude(), equalTo(2.2));
        assertThat(earthquake2.getTime().get(Calendar.YEAR), equalTo(2012));
        assertThat(earthquake2.getTime().get(Calendar.MONTH), equalTo(Calendar.FEBRUARY));
        assertThat(earthquake2.getTime().get(Calendar.DAY_OF_MONTH), equalTo(2));
        assertThat(earthquake2.getTime().get(Calendar.HOUR_OF_DAY), equalTo(22));
        assertThat(earthquake2.getTime().get(Calendar.MINUTE), equalTo(22));
        assertThat(earthquake2.getLocation().getLatitude(), equalTo(2.2));
        assertThat(earthquake2.getLocation().getLongitude(), equalTo(2.2));
    }

    @Test
    public void buildEarthquake_shouldBuildAnEarthquakeFromEvent() {
        Event event = anEvent()
                .withId("dummy-id")
                .withMagnitude(aMagnitude()
                        .withMag(aMag()
                                .withValue(1.2)
                                .build())
                        .build())
                .withOrigin(anOrigin()
                        .withLatitude(aLatitude()
                                .withValue(3.4)
                                .build())
                        .withLongitude(aLongitude()
                                .withValue(5.6)
                                .build())
                        .withTime(aTime()
                                .withValue("2012-03-04T05:06:00.000Z")
                                .build())
                        .build())
                .build();

        Earthquake earthquake = converter.buildEarthquake(event);

        assertThat(earthquake.getId(), equalTo("dummy-id"));
        assertThat(earthquake.getLocation().getLatitude(), equalTo(3.4));
        assertThat(earthquake.getLocation().getLongitude(), equalTo(5.6));
        assertThat(earthquake.getMagnitude(), equalTo(1.2));
        assertThat(earthquake.getTime().get(Calendar.YEAR), equalTo(2012));
        assertThat(earthquake.getTime().get(Calendar.MONTH), equalTo(Calendar.MARCH));
        assertThat(earthquake.getTime().get(Calendar.DAY_OF_MONTH), equalTo(4));
        assertThat(earthquake.getTime().get(Calendar.HOUR_OF_DAY), equalTo(5));
        assertThat(earthquake.getTime().get(Calendar.MINUTE), equalTo(6));
    }

    @Test
    public void populateId_shouldPopulateEarthquakeIdFromEvent() {
        Event event = anEvent().withId("EventId1").build();
        Earthquake earthquake = new Earthquake();

        converter.populateId(earthquake, event);

        assertThat(earthquake.getId(), equalTo("EventId1"));
    }

    @Test
    public void populateTime_shouldPopulateEarthquakeTimeFromEvent() {
        Event event = anEvent()
                .withOrigin(anOrigin()
                        .withTime(aTime()
                                .withValue("2012-03-04T05:06:00.000Z")
                                .build())
                        .build())
                .build();
        Earthquake earthquake = new Earthquake();

        converter.populateTime(earthquake, event);

        assertThat(earthquake.getTime().get(Calendar.YEAR), equalTo(2012));
        assertThat(earthquake.getTime().get(Calendar.MONTH), equalTo(Calendar.MARCH));
        assertThat(earthquake.getTime().get(Calendar.DAY_OF_MONTH), equalTo(4));
        assertThat(earthquake.getTime().get(Calendar.HOUR_OF_DAY), equalTo(5));
        assertThat(earthquake.getTime().get(Calendar.MINUTE), equalTo(6));
    }

    @Test(expected = DateParseException.class)
    public void populateTime_shouldThrowExceptionIfTimeFormatIsWrong() {
        Event event = anEvent()
                .withOrigin(anOrigin()
                        .withTime(aTime()
                                .withValue("wrong-date-format")
                                .build())
                        .build())
                .build();
        Earthquake earthquake = new Earthquake();

        converter.populateTime(earthquake, event);
    }

    @Test
    public void populateLocation_shouldPopulateEarthquakeLocationFromEvent() {
        Event event = anEvent()
                .withOrigin(anOrigin()
                        .withLatitude(aLatitude()
                                .withValue(1.2)
                                .build())
                        .withLongitude(aLongitude()
                                .withValue(3.4)
                                .build())
                        .build())
                .build();
        Earthquake earthquake = new Earthquake();

        converter.populateLocation(earthquake, event);

        assertThat(earthquake.getLocation().getLatitude(), equalTo(1.2));
        assertThat(earthquake.getLocation().getLongitude(), equalTo(3.4));
    }

    @Test
    public void populateMagnitude_shouldPopulateEarthquakeMagnitudeFromEvent() {
        Event event = anEvent()
                .withMagnitude(aMagnitude()
                        .withMag(aMag()
                                .withValue(1.2)
                                .build())
                        .build())
                .build();
        Earthquake earthquake = new Earthquake();

        converter.populateMagnitude(earthquake, event);

        assertThat(earthquake.getMagnitude(), equalTo(1.2));
    }
}