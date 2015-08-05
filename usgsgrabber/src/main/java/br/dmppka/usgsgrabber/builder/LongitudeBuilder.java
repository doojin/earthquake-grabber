package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Longitude;

public class LongitudeBuilder {

    private double value;

    public static LongitudeBuilder aLongitude() {
        return new LongitudeBuilder();
    }

    public LongitudeBuilder withValue(double value) {
        this.value = value;
        return this;
    }

    public Longitude build() {
        Longitude longitude = new Longitude();
        longitude.setValue(value);
        return longitude;
    }
}
