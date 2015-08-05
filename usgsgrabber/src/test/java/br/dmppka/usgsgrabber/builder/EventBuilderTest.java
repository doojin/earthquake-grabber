package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.Magnitude;
import br.dmppka.usgsgrabber.model.xml.Origin;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.EventBuilder.anEvent;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EventBuilderTest {

    @Test
    public void build_shouldBuildCorrectEventObject() {
        Magnitude magnitude = new Magnitude();
        Origin origin = new Origin();

        Event event = anEvent()
                .withId("EventId")
                .withMagnitude(magnitude)
                .withOrigin(origin)
                .build();

        assertThat(event.getId(), equalTo("EventId"));
        assertThat(event.getMagnitude(), equalTo(magnitude));
        assertThat(event.getOrigin(), equalTo(origin));
    }
}