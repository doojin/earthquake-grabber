package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Calendar;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class URIBuilderTest {

    private URIBuilder uriBuilder;
    private USGSRestConfig config;
    private UriComponentsBuilder uriComponentsBuilder;

    @Before
    public void setUp() {
        uriBuilder = new URIBuilder();
        config = new USGSRestConfig();
        uriComponentsBuilder = mock(UriComponentsBuilder.class);
    }

    @Test
    public void getUriBuilder_shouldSetCorrectURIToBuilder() {
        UriComponentsBuilder builder = uriBuilder.getUriBuilder();

        assertThat(builder.toUriString(), equalTo("http://earthquake.usgs.gov/fdsnws/event/1/query"));
    }

    @Test
    public void addResponseFormatParam_shouldNotAddResponseFormatParamIfItIsNull() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addResponseFormatParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_RESPONSE_FORMAT, config.getResponseFormat());
    }

    @Test
    public void addResponseFormatParam_shouldAddResponseFormatParamIfItIsNotNull() {
        uriBuilder = spy(uriBuilder);
        config.setResponseFormat(ResponseFormat.CSV);

        uriBuilder.addResponseFormatParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_RESPONSE_FORMAT, "csv");
    }

    @Test
    public void addStartTimeParam_shouldNotAddStartTimeParamIfItIsNull() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addStartTimeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_START_TIME, config.getStartTime());
    }

    @Test
    public void addStartTimeParam_shouldAddStartTimeParamIfItIsNotNull() {
        uriBuilder = spy(uriBuilder);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1, 15, 25);
        config.setStartTime(calendar);

        uriBuilder.addStartTimeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_START_TIME, "2015-01-01T15:25Z");
    }

    @Test
    public void addEndTimeParam_shouldNotAddEndTimeParamIfItIsNull() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addEndTimeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_END_TIME, config.getEndTime());
    }

    @Test
    public void addEndTimeParam_shouldAddEndTimeParamIfItIsNotNull() {
        uriBuilder = spy(uriBuilder);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1, 15, 25);
        config.setEndTime(calendar);

        uriBuilder.addEndTimeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_END_TIME, "2015-01-01T15:25Z");
    }

    @Test
    public void addMinLatitudeParam_shouldNotAddMinLatitudeParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addMinLatitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_MIN_LATITUDE, config.getMinMagnitude());
    }

    @Test
    public void addMinLatitudeParam_shouldAddMinLatitudeParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setMinLatitude(-2.5);

        uriBuilder.addMinLatitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_MIN_LATITUDE, -2.5);
    }

    @Test
    public void addMaxLatitudeParam_shouldNotAddMaxLatitudeParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addMaxLatitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_MAX_LATITUDE, config.getMaxLatitude());
    }

    @Test
    public void addMaxLatitudeParam_shouldAddMaxLatitudeParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setMaxLatitude(-2.5);

        uriBuilder.addMaxLatitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_MAX_LATITUDE, -2.5);
    }

    @Test
    public void addMinLongitudeParam_shouldNotAddMinLongitudeParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addMinLongitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_MIN_LONGITUDE, config.getMinLongitude());
    }

    @Test
    public void addMinLongitudeParam_shouldAddMinLongitudeParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setMinLongitude(-2.5);

        uriBuilder.addMinLongitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_MIN_LONGITUDE, -2.5);
    }

    @Test
    public void addMaxLongitudeParam_shouldNotAddMaxLongitudeParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addMaxLongitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_MAX_LONGITUDE, config.getMaxLongitude());
    }

    @Test
    public void addMaxLongitudeParam_shouldAddMaxLongitudeParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setMaxLongitude(-2.5);

        uriBuilder.addMaxLongitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_MAX_LONGITUDE, -2.5);
    }

    @Test
    public void addEventIdParam_shouldNotAddEventIdParamIfItIsNull() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addEventIdParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_EVENT_ID, config.getEventId());
    }

    @Test
    public void addEventIdParam_shouldAddEventIdParamIfItIsNotNull() {
        uriBuilder = spy(uriBuilder);
        config.setEventId("dummyId");

        uriBuilder.addEventIdParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_EVENT_ID, "dummyId");
    }

    @Test
    public void addLimitParam_shouldNotAddLimitParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addLimitParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_LIMIT, config.getLimit());
    }

    @Test
    public void addLimitParam_shouldAddLimitParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setLimit(2);

        uriBuilder.addLimitParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_LIMIT, 2);
    }

    @Test
    public void addMinMagnitudeParam_shouldNotAdMinMagnitudeParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addMinMagnitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_MIN_MAGNITUDE, config.getMinMagnitude());
    }

    @Test
    public void addMinMagnitudeParam_shouldAddMinMagnitudeParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setMinMagnitude(2.5);

        uriBuilder.addMinMagnitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_MIN_MAGNITUDE, 2.5);
    }

    @Test
    public void addMaxMagnitudeParam_shouldNotAddMaxMagnitudeParamIfItIsZero() {
        uriBuilder = spy(uriBuilder);

        uriBuilder.addMaxMagnitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, never()).queryParam(URIBuilder.P_MAX_MAGNITUDE, config.getMaxMagnitude());
    }

    @Test
    public void addMaxMagnitudeParam_shouldAddMaxMagnitudeParamIfItIsNotZero() {
        uriBuilder = spy(uriBuilder);
        config.setMaxMagnitude(2.5);

        uriBuilder.addMaxMagnitudeParam(uriComponentsBuilder, config);

        verify(uriComponentsBuilder, times(1)).queryParam(URIBuilder.P_MAX_MAGNITUDE, 2.5);
    }
}