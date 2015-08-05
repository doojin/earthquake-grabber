package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Mag;

public class MagBuilder {

    private double value;

    public static MagBuilder aMag() {
        return new MagBuilder();
    }

    public MagBuilder withValue(double value) {
        this.value = value;
        return this;
    }

    public Mag build() {
        Mag mag = new Mag();
        mag.setValue(value);
        return mag;
    }
}
