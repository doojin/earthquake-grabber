package br.dmppka.usgsgrabber.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Origin {

    @JacksonXmlProperty(localName = "time")
    private Time time;

    @JacksonXmlProperty(localName = "longitude")
    private Longitude longitude;

    @JacksonXmlProperty(localName = "latitude")
    private Latitude latitude;

    public Latitude getLatitude() {
        return latitude;
    }

    public void setLatitude(Latitude latitude) {
        this.latitude = latitude;
    }

    public Longitude getLongitude() {
        return longitude;
    }

    public void setLongitude(Longitude longitude) {
        this.longitude = longitude;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
