package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.EventParameters;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class EventParametersBuilder {

    private List<Event> events;

    public static EventParametersBuilder anEventParameters() {
        return new EventParametersBuilder();
    }

    public EventParametersBuilder withEvents(Event... events) {
        this.events = newArrayList(events);
        return this;
    }

    public EventParameters build() {
        EventParameters eventParameters = new EventParameters();
        eventParameters.setEvents(events);
        return eventParameters;
    }
}
