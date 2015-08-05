package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Latitude;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.LatitudeBuilder.aLatitude;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LatitudeBuilderTest {

    @Test
    public void build_shouldCreateCorrectLatitudeObject() {
        Latitude latitude = aLatitude()
                .withValue(1.2)
                .build();

        assertThat(latitude.getValue(), equalTo(1.2));
    }
}