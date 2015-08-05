package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.Time;

public class TimeBuilder {

    private String value;

    public static TimeBuilder aTime() {
        return new TimeBuilder();
    }

    public TimeBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    public Time build() {
        Time time = new Time();
        time.setValue(value);
        return time;
    }
}
