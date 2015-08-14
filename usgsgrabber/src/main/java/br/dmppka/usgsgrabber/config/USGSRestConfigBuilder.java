package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.ResponseFormat;
import br.dmppka.usgsgrabber.exception.DateParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class USGSRestConfigBuilder {

    public static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";

    private ResponseFormat responseFormat;
    private Calendar startTime;
    private Calendar endTime;

    // Location
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;

    private String eventId;
    private int limit;
    private double minMagnitude;
    private double maxMagnitude;

    public USGSRestConfig build() {
        USGSRestConfig config = new USGSRestConfig();
        config.setResponseFormat(responseFormat);
        config.setStartTime(startTime);
        config.setEndTime(endTime);
        config.setMinLatitude(minLatitude);
        config.setMaxLatitude(maxLatitude);
        config.setMinLongitude(minLongitude);
        config.setMaxLongitude(maxLongitude);
        config.setEventId(eventId);
        config.setLimit(limit);
        config.setMinMagnitude(minMagnitude);
        config.setMaxMagnitude(maxMagnitude);
        return config;
    }

    public USGSRestConfigBuilder withResponseFormat(ResponseFormat format) {
        this.responseFormat = format;
        return this;
    }

    public USGSRestConfigBuilder withStartTime(Calendar startTime) {
        this.startTime = startTime;
        return this;
    }

    public USGSRestConfigBuilder withStartTime(String startTime, String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = new SimpleDateFormat(dateFormat).parse(startTime);
            calendar.setTime(date);
            this.startTime = calendar;
        } catch (ParseException e) {
            throw new DateParseException(startTime);
        }
        return this;
    }

    public USGSRestConfigBuilder withStartTime(String startTime) {
        return withStartTime(startTime, DATE_FORMAT);
    }

    public USGSRestConfigBuilder withEndTime(Calendar endTime) {
        this.endTime = endTime;
        return this;
    }

    public USGSRestConfigBuilder withEndTime(String endTime, String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = new SimpleDateFormat(dateFormat).parse(endTime);
            calendar.setTime(date);
            this.endTime = calendar;
        } catch (ParseException e) {
            throw new DateParseException(endTime);
        }
        return this;
    }

    public USGSRestConfigBuilder withEndTime(String endTime) {
        return withEndTime(endTime, DATE_FORMAT);
    }

    public USGSRestConfigBuilder withMinLatitude(double latitude) {
        this.minLatitude = latitude;
        return this;
    }

    public USGSRestConfigBuilder withMaxLatitude(double latitude) {
        this.maxLatitude = latitude;
        return this;
    }

    public USGSRestConfigBuilder withMinLongitude(double longitude) {
        this.minLongitude = longitude;
        return this;
    }

    public USGSRestConfigBuilder withMaxLongitude(double longitude) {
        this.maxLongitude = longitude;
        return this;
    }

    public USGSRestConfigBuilder withEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public USGSRestConfigBuilder withLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public USGSRestConfigBuilder withMinMagnitude(double magnitude) {
        this.minMagnitude = magnitude;
        return this;
    }

    public USGSRestConfigBuilder withMaxMagnitude(double magnitude) {
        this.maxMagnitude = magnitude;
        return this;
    }
}