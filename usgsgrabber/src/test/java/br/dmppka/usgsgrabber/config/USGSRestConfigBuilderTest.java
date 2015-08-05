package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.ResponseFormat;
import br.dmppka.usgsgrabber.exception.DateParseException;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class USGSRestConfigBuilderTest {

    @Test
    public void build_shouldFillConfigWithValidValues() {
        Calendar startTime = Calendar.getInstance();
        startTime.set(2010, Calendar.MAY, 10, 15, 25, 0);
        startTime.set(Calendar.MILLISECOND, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2010, Calendar.JUNE, 20, 15, 25, 0);
        endTime.set(Calendar.MILLISECOND, 0);
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withResponseFormat(ResponseFormat.XML)
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

        assertThat(config.getResponseFormatValue(), equalTo("xml"));
        assertThat(config.getStartTime(), equalTo("2010-05-10T15:25:00.000Z"));
        assertThat(config.getEndTime(), equalTo("2010-06-20T15:25:00.000Z"));
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
    public void withStartTime_shouldConvertStringToDate() {
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withStartTime("21.03.1991 12:05:51")
                .build();
        String startTime = config.getStartTime();

        assertThat(startTime, equalTo("1991-03-21T12:05:51.000Z"));

    }

    @Test
    public void withEndTime_shouldConvertStringToDate() {
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withEndTime("21.03.1991 12:05:51")
                .build();
        String endTime = config.getEndTime();

        assertThat(endTime, equalTo("1991-03-21T12:05:51.000Z"));
    }

    @Test(expected = DateParseException.class)
    public void withStartTime_shouldThrowErrorIfDateFormatIsWrong() {
        new USGSRestConfigBuilder().withStartTime("wrongDateFormat");
    }

    @Test(expected = DateParseException.class)
    public void withEndTime_shouldThrowErrorIfDateFormatIsWrong() {
        new USGSRestConfigBuilder().withEndTime("wrongDateFormat");
    }
}