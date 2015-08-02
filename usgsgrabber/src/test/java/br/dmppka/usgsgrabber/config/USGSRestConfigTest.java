package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.ResponseFormat;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class USGSRestConfigTest {

    private USGSRestConfig config;

    @Before
    public void before() {
        config = new USGSRestConfig();
    }

    @Test
    public void getResponseFormat_shouldReturnNullIfResponseFormatIsNull() {
        config.setResponseFormat(null);

        assertThat(config.getResponseFormat(), equalTo(null));
    }

    @Test
    public void getResponseFormat_shouldReturnTextRepresentationOfResponseFormat() {
        USGSRestConfig config1 = new USGSRestConfig();
        config1.setResponseFormat(ResponseFormat.CSV);

        USGSRestConfig config2 = new USGSRestConfig();
        config2.setResponseFormat(ResponseFormat.GEO_JSON);

        USGSRestConfig config3 = new USGSRestConfig();
        config3.setResponseFormat(ResponseFormat.KML);

        USGSRestConfig config4 = new USGSRestConfig();
        config4.setResponseFormat(ResponseFormat.TEXT);

        USGSRestConfig config5 = new USGSRestConfig();
        config5.setResponseFormat(ResponseFormat.XML);

        assertThat(config1.getResponseFormat(), equalTo("csv"));
        assertThat(config2.getResponseFormat(), equalTo("geojson"));
        assertThat(config3.getResponseFormat(), equalTo("kml"));
        assertThat(config4.getResponseFormat(), equalTo("text"));
        assertThat(config5.getResponseFormat(), equalTo("xml"));
    }

    @Test
    public void getStartTime_shouldReturnNullIfStartDateIsNull() {
        config.setStartTime(null);

        assertThat(config.getStartTime(), equalTo(null));
    }

    @Test
    public void getStartTime_shouldReturnFormattedDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 25, 13, 45);
        config.setStartTime(calendar);

        assertThat(config.getStartTime(), equalTo("2015-01-25T13:45Z"));
    }

    @Test
    public void getEndTime_shouldReturnNullIfEndDateIsNull() {
        config.setEndTime(null);

        assertThat(config.getEndTime(), equalTo(null));
    }

    @Test
    public void getEndTime_shouldReturnFormattedDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 25, 13, 45);
        config.setEndTime(calendar);

        assertThat(config.getEndTime(), equalTo("2015-01-25T13:45Z"));
    }
}