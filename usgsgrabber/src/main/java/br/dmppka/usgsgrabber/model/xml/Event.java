package br.dmppka.usgsgrabber.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Event {

    @JacksonXmlProperty(isAttribute = true, namespace = "catalog", localName = "eventid")
    private String id;

    @JacksonXmlProperty(localName = "origin")
    private Origin origin;

    @JacksonXmlProperty(localName = "magnitude")
    private Magnitude magnitude;

    public String getId() {
        return id;
    }

    public void setId(String eventId) {
        this.id = eventId;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }
}
