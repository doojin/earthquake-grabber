package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.config.USGSRestConfigBuilder;
import br.dmppka.usgsgrabber.model.xml.Event;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class USGSGatewayIntegrationTest {

    private USGSGateway gateway = USGSGateway.getInstance();

    @Test
    public void getXMLResponse_shouldCreateAValidUSGSXMLResponseObject() {
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withMinLongitude(-90)
                .withMaxLongitude(90)
                .withMinLatitude(-90)
                .withMaxLatitude(90)
                .withStartTime("01.01.2012 00:00:00")
                .withEndTime("02.01.2012 00:00:00")
                .withLimit(2)
                .withMinMagnitude(1)
                .withMaxMagnitude(10)
                .build();

        USGSXMLResponse response = gateway.getXMLResponse(config);
        List<Event> events = response.getEventParameters().getEvents();
        Event event1 = events.get(0);
        Event event2 = events.get(1);

        assertThat(response.getEventParameters().getEvents().size(), equalTo(2));

        assertThat(event1.getId(), equalTo("p000jcy5"));
        assertThat(event1.getOrigin().getLatitude().getValue(), equalTo(45.03));
        assertThat(event1.getOrigin().getLongitude().getValue(), equalTo(23.54));
        assertThat(event1.getOrigin().getTime().getValue(), equalTo("2012-01-01T23:57:19.400Z"));
        assertThat(event1.getMagnitude().getMag().getValue(), equalTo(4.5));

        assertThat(event2.getId(), equalTo("p000jcy1"));
        assertThat(event2.getOrigin().getLatitude().getValue(), equalTo(-34.92));
        assertThat(event2.getOrigin().getLongitude().getValue(), equalTo(-72.759));
        assertThat(event2.getOrigin().getTime().getValue(), equalTo("2012-01-01T21:58:16.000Z"));
        assertThat(event2.getMagnitude().getMag().getValue(), equalTo(4.1));
    }

}