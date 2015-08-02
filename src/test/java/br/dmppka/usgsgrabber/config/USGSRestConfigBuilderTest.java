package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.RequestType;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class USGSRestConfigBuilderTest {

    @Test
    public void build_shouldFillConfigWithValidValues() {
        Calendar startTime = Calendar.getInstance();
        startTime.set(2010, Calendar.MAY, 10);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2010, Calendar.JUNE, 20);
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withRequestType(RequestType.XML)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withMinLatitude(1.2)
                .withMaxLatitude(2.3)
                .withMinLongitude(3.4)
                .withMaxLongitude(4.5)
                .withEventId("DummyEventId")
                .withLimit(5)
                .withMinMagnitude(5.6)
                .withMaxMagnitude(6.7)
                .build();

        assertThat(config.getRequestType(), equalTo(RequestType.XML));
        assertThat(config.getStartTime(), equalTo(startTime));
        assertThat(config.getEndTime(), equalTo(endTime));
        assertThat(config.getMinLatitude(), equalTo(1.2));
        assertThat(config.getMaxLatitude(), equalTo(2.3));
        assertThat(config.getMinLongitude(), equalTo(3.4));
        assertThat(config.getMaxLongitude(), equalTo(4.5));
        assertThat(config.getEventId(), equalTo("DummyEventId"));
        assertThat(config.getLimit(), equalTo(5));
        assertThat(config.getMinMagnitude(), equalTo(5.6));
        assertThat(config.getMaxMagnitude(), equalTo(6.7));
    }

    @Test
    public void withStartTime_shouldConvertStringToDate() throws ParseException {
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withStartTime("21.03.1991 12:05:51")
                .build();
        Calendar startTime = config.getStartTime();

        assertThat(startTime.get(Calendar.DAY_OF_MONTH), equalTo(21));
        assertThat(startTime.get(Calendar.MONTH), equalTo(Calendar.MARCH));
        assertThat(startTime.get(Calendar.YEAR), equalTo(1991));
        assertThat(startTime.get(Calendar.HOUR_OF_DAY), equalTo(12));
        assertThat(startTime.get(Calendar.MINUTE), equalTo(5));
        assertThat(startTime.get(Calendar.SECOND), equalTo(51));
    }

    @Test
    public void withEndTime_shouldConvertStringToDate() throws ParseException {
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withEndTime("21.03.1991 12:05:51")
                .build();
        Calendar endTime = config.getEndTime();

        assertThat(endTime.get(Calendar.DAY_OF_MONTH), equalTo(21));
        assertThat(endTime.get(Calendar.MONTH), equalTo(Calendar.MARCH));
        assertThat(endTime.get(Calendar.YEAR), equalTo(1991));
        assertThat(endTime.get(Calendar.HOUR_OF_DAY), equalTo(12));
        assertThat(endTime.get(Calendar.MINUTE), equalTo(5));
        assertThat(endTime.get(Calendar.SECOND), equalTo(51));
    }

}