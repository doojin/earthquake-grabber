package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Mag;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.MagBuilder.aMag;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MagBuilderTest {

    @Test
    public void build_shouldCreateCorrectMagObject() {
        Mag mag = aMag()
                .withValue(1.2)
                .build();

        assertThat(mag.getValue(), equalTo(1.2));
    }
}