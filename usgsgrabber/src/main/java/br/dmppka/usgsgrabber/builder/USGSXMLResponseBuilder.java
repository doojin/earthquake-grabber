package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.EventParameters;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;

public class USGSXMLResponseBuilder {

    private EventParameters eventParameters;

    public static USGSXMLResponseBuilder anUSGSXMLResponse() {
        return new USGSXMLResponseBuilder();
    }

    public USGSXMLResponseBuilder withEventParameters(EventParameters eventParameters) {
        this.eventParameters = eventParameters;
        return this;
    }

    public USGSXMLResponse build() {
        USGSXMLResponse response = new USGSXMLResponse();
        response.setEventParameters(eventParameters);
        return response;
    }
}
