package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Mag;
import br.dmppka.usgsgrabber.model.xml.Magnitude;

public class MagnitudeBuilder {

    private Mag mag;

    public static MagnitudeBuilder aMagnitude() {
        return new MagnitudeBuilder();
    }

    public MagnitudeBuilder withMag(Mag mag) {
        this.mag = mag;
        return this;
    }

    public Magnitude build() {
        Magnitude magnitude = new Magnitude();
        magnitude.setMag(mag);
        return magnitude;
    }
}
