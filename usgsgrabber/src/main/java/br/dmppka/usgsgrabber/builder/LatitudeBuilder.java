package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Latitude;

public class LatitudeBuilder {

    private double value;

    public static LatitudeBuilder aLatitude() {
        return new LatitudeBuilder();
    }

    public LatitudeBuilder withValue(double value) {
        this.value = value;
        return this;
    }

    public Latitude build() {
        Latitude latitude = new Latitude();
        latitude.setValue(value);
        return latitude;
    }
}
