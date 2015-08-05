package br.dmppka.usgsgrabber.model.xml;

import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.MagnitudeBuilder.aMagnitude;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MagnitudeTest {

    @Test
    public void build_shouldCreateCorrectMagnitudeObject() {
        Mag mag = new Mag();
        Magnitude magnitude = aMagnitude()
                .withMag(mag)
                .build();

        assertThat(magnitude.getMag(), equalTo(mag));
    }
}