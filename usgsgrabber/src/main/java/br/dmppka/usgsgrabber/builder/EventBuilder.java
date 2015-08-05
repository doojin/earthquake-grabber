package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.Magnitude;
import br.dmppka.usgsgrabber.model.xml.Origin;

public class EventBuilder {

    private String id;
    private Origin origin;
    private Magnitude magnitude;

    public static EventBuilder anEvent() {
        return new EventBuilder();
    }

    public EventBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public EventBuilder withOrigin(Origin origin) {
        this.origin = origin;
        return this;
    }

    public EventBuilder withMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
        return this;
    }

    public Event build() {
        Event event = new Event();
        event.setId(id);
        event.setOrigin(origin);
        event.setMagnitude(magnitude);
        return event;
    }
}
