package br.dmppka.usgsgrabber.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class USGSXMLResponse {

    @JacksonXmlProperty(localName = "eventParameters")
    private EventParameters eventParameters;

    public EventParameters getEventParameters() {
        return eventParameters;
    }

    public void setEventParameters(EventParameters eventParameters) {
        this.eventParameters = eventParameters;
    }
}
