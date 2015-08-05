package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Latitude;
import br.dmppka.usgsgrabber.model.xml.Longitude;
import br.dmppka.usgsgrabber.model.xml.Origin;
import br.dmppka.usgsgrabber.model.xml.Time;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.OriginBuilder.anOrigin;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OriginBuilderTest {

    @Test
    public void build_shouldCreateCorrectOriginObject() {
        Latitude latitude = new Latitude();
        Longitude longitude = new Longitude();
        Time time = new Time();

        Origin origin = anOrigin()
                .withLatitude(latitude)
                .withLongitude(longitude)
                .withTime(time)
                .build();

        assertThat(origin.getTime(), equalTo(time));
        assertThat(origin.getLatitude(), equalTo(latitude));
        assertThat(origin.getLongitude(), equalTo(longitude));
    }

}