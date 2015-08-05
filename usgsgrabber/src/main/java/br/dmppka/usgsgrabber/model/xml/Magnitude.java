package br.dmppka.usgsgrabber.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Magnitude {

    @JacksonXmlProperty(localName = "mag")
    private Mag mag;

    public Mag getMag() {
        return mag;
    }

    public void setMag(Mag mag) {
        this.mag = mag;
    }
}
