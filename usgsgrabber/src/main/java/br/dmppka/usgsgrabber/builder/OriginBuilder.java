package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Latitude;
import br.dmppka.usgsgrabber.model.xml.Longitude;
import br.dmppka.usgsgrabber.model.xml.Origin;
import br.dmppka.usgsgrabber.model.xml.Time;

public class OriginBuilder {

    private Time time;
    private Longitude longitude;
    private Latitude latitude;

    public static OriginBuilder anOrigin() {
        return new OriginBuilder();
    }

    public OriginBuilder withTime(Time time) {
        this.time = time;
        return this;
    }

    public OriginBuilder withLongitude(Longitude longitude) {
        this.longitude = longitude;
        return this;
    }

    public OriginBuilder withLatitude(Latitude latitude) {
        this.latitude = latitude;
        return this;
    }

    public Origin build() {
        Origin origin = new Origin();
        origin.setLatitude(latitude);
        origin.setLongitude(longitude);
        origin.setTime(time);
        return origin;
    }
}
