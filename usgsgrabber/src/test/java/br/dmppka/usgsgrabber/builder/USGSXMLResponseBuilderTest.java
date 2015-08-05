package br.dmppka.usgsgrabber.builder;

import br.dmppka.usgsgrabber.model.xml.EventParameters;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;
import org.junit.Test;

import static br.dmppka.usgsgrabber.builder.USGSXMLResponseBuilder.anUSGSXMLResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class USGSXMLResponseBuilderTest {

    @Test
    public void build_shouldBuildCorrectUSGSXMLResponseObject() {
        EventParameters eventParameters = new EventParameters();

        USGSXMLResponse response = anUSGSXMLResponse()
                .withEventParameters(eventParameters)
                .build();

        assertThat(response.getEventParameters(), equalTo(eventParameters));
    }

}