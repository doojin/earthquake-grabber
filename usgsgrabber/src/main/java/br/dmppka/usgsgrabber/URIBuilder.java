package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.exception.URIFormatException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class URIBuilder {

    public static final String URI_BASE = "http://earthquake.usgs.gov/fdsnws/event/1/query";

    public static final String P_RESPONSE_FORMAT = "format";
    public static final String P_START_TIME = "starttime";
    public static final String P_END_TIME = "endtime";
    public static final String P_MIN_LATITUDE = "minlatitude";
    public static final String P_MAX_LATITUDE = "maxlatitude";
    public static final String P_MIN_LONGITUDE = "minlongitude";
    public static final String P_MAX_LONGITUDE = "maxlongitude";
    public static final String P_EVENT_ID = "eventid";
    public static final String P_LIMIT = "limit";
    public static final String P_MIN_MAGNITUDE = "minmagnitude";
    public static final String P_MAX_MAGNITUDE = "maxmagnitude";

    public String build(USGSRestConfig config) {
        UriComponentsBuilder uriBuilder = getUriBuilder();

        // Setting non-nullable URI parameters
        addResponseFormatParam(uriBuilder, config);
        addStartTimeParam(uriBuilder, config);
        addEndTimeParam(uriBuilder, config);
        addMinLatitudeParam(uriBuilder, config);
        addMaxLatitudeParam(uriBuilder, config);
        addMinLongitudeParam(uriBuilder, config);
        addMaxLongitudeParam(uriBuilder, config);
        addEventIdParam(uriBuilder, config);
        addLimitParam(uriBuilder, config);
        addMinMagnitudeParam(uriBuilder, config);
        addMaxMagnitudeParam(uriBuilder, config);

        return uriBuilder.toUriString();
    }

    UriComponentsBuilder getUriBuilder() {
        try {
            return UriComponentsBuilder.fromUri(new URI(URI_BASE));
        } catch(URISyntaxException e) {
            throw new URIFormatException(URI_BASE);
        }
    }

    void addResponseFormatParam(UriComponentsBuilder builder, USGSRestConfig config) {
        String responseFormat = config.getResponseFormatValue();
        if (responseFormat != null) {
            builder.queryParam(P_RESPONSE_FORMAT, responseFormat);
        }
    }

    void addStartTimeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        String startTime = config.getStartTime();
        if (startTime != null) {
            builder.queryParam(P_START_TIME, startTime);
        }
    }

    void addEndTimeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        String endTime = config.getEndTime();
        if (endTime != null) {
            builder.queryParam(P_END_TIME, endTime);
        }
    }

    void addMinLatitudeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        double minLatitude = config.getMinLatitude();
        if (minLatitude != 0) {
            builder.queryParam(P_MIN_LATITUDE, minLatitude);
        }
    }

    void addMaxLatitudeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        double maxLatitude = config.getMaxLatitude();
        if (maxLatitude != 0) {
            builder.queryParam(P_MAX_LATITUDE, maxLatitude);
        }
    }

    void addMinLongitudeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        double minLongitude = config.getMinLongitude();
        if (minLongitude != 0) {
            builder.queryParam(P_MIN_LONGITUDE, minLongitude);
        }
    }

    void addMaxLongitudeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        double maxLongitude = config.getMaxLongitude();
        if (maxLongitude != 0) {
            builder.queryParam(P_MAX_LONGITUDE, maxLongitude);
        }
    }

    void addEventIdParam(UriComponentsBuilder builder, USGSRestConfig config) {
        String eventId = config.getEventId();
        if (eventId != null) {
            builder.queryParam(P_EVENT_ID, eventId);
        }
    }

    void addLimitParam(UriComponentsBuilder builder, USGSRestConfig config) {
        int limit = config.getLimit();
        if (limit != 0) {
            builder.queryParam(P_LIMIT, limit);
        }
    }

    void addMinMagnitudeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        double minMagnitude = config.getMinMagnitude();
        if (minMagnitude != 0) {
            builder.queryParam(P_MIN_MAGNITUDE, minMagnitude);
        }
    }

    void addMaxMagnitudeParam(UriComponentsBuilder builder, USGSRestConfig config) {
        double maxMagnitude = config.getMaxMagnitude();
        if (maxMagnitude != 0) {
            builder.queryParam(P_MAX_MAGNITUDE, maxMagnitude);
        }
    }
}