package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Time;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.TimeBuilder.aTime;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TimeBuilderTest {

    @Test
    public void build_shouldCreateCorrectTimeObject() {
        Time time = aTime()
                .withValue("2012-03-04T05:06")
                .build();

        assertThat(time.getValue(), equalTo("2012-03-04T05:06"));
    }

}