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

        assertThat(config.getResponseFormatValue(), equalTo(null));
    }

    @Test
    public void getResponseFormat_shouldReturnTextRepresentationOfResponseFormat() {
        USGSRestConfig config = new USGSRestConfig();
        config.setResponseFormat(ResponseFormat.XML);

        assertThat(config.getResponseFormatValue(), equalTo("xml"));
    }

    @Test
    public void getStartTime_shouldReturnNullIfStartDateIsNull() {
        config.setStartTime(null);

        assertThat(config.getStartTime(), equalTo(null));
    }

    @Test
    public void getStartTime_shouldReturnFormattedDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 25, 13, 45, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        config.setStartTime(calendar);

        assertThat(config.getStartTime(), equalTo("2015-01-25T13:45:00.000Z"));
    }

    @Test
    public void getEndTime_shouldReturnNullIfEndDateIsNull() {
        config.setEndTime(null);

        assertThat(config.getEndTime(), equalTo(null));
    }

    @Test
    public void getEndTime_shouldReturnFormattedDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 25, 13, 45, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        config.setEndTime(calendar);

        assertThat(config.getEndTime(), equalTo("2015-01-25T13:45:00.000Z"));
    }
}