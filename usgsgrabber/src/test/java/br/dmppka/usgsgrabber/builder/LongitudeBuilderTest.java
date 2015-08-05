package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Longitude;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.LongitudeBuilder.aLongitude;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongitudeBuilderTest {

    @Test
    public void build_shouldCreateCorrectLongitudeObject() {
        Longitude longitude = aLongitude()
                .withValue(1.2)
                .build();

        assertThat(longitude.getValue(), equalTo(1.2));
    }
}