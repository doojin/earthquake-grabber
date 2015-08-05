package br.dmppka.usgsgrabber.converter;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.exception.DateParseException;
import br.dmppka.usgsgrabber.model.Earthquake;
import br.dmppka.usgsgrabber.model.Location;
import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.Origin;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;
import org.dozer.CustomConverter;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class USGSXMLResponseToEarthquakeListConverter implements CustomConverter {

    public List<Earthquake> convert(Object o, Object src, Class<?> aClass, Class<?> aClass1) {
        USGSXMLResponse response = (USGSXMLResponse) src;
        List<Event> events = response.getEventParameters().getEvents();
        List<Earthquake> earthquakes = newArrayList();
        for (Event event : events) {
            earthquakes.add(buildEarthquake(event));
        }
        return earthquakes;
    }

    Earthquake buildEarthquake(Event event) {
        Earthquake earthquake = new Earthquake();
        populateId(earthquake, event);
        populateTime(earthquake, event);
        populateLocation(earthquake, event);
        populateMagnitude(earthquake, event);
        return earthquake;
    }

    void populateId(Earthquake earthquake, Event event) {
        String id = event.getId();
        earthquake.setId(id);
    }

    void populateTime(Earthquake earthquake, Event event) {
        Origin origin = event.getOrigin();
        String time = origin.getTime().getValue();
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(USGSRestConfig.ISO8601.parse(time));
        } catch (ParseException e) {
            throw new DateParseException(time);
        }
        earthquake.setTime(calendar);
    }

    void populateLocation(Earthquake earthquake, Event event) {
        Origin origin = event.getOrigin();
        Location location = new Location();
        location.setLatitude(origin.getLatitude().getValue());
        location.setLongitude(origin.getLongitude().getValue());
        earthquake.setLocation(location);
    }

    void populateMagnitude(Earthquake earthquake, Event event) {
        double magnitude = event.getMagnitude().getMag().getValue();
        earthquake.setMagnitude(magnitude);
    }

}
