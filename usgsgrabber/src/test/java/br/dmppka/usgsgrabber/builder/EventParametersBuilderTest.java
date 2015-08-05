package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.EventParameters;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.EventParametersBuilder.anEventParameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EventParametersBuilderTest {

    @Test
    public void build_shouldBuildCorrectEventParametersObject() {
        Event event1 = new Event();
        Event event2 = new Event();

        EventParameters eventParameters = anEventParameters()
                .withEvents(event1, event2)
                .build();

        assertThat(eventParameters.getEvents().size(), equalTo(2));
        assertThat(eventParameters.getEvents().get(0), equalTo(event1));
        assertThat(eventParameters.getEvents().get(1), equalTo(event2));
    }

}