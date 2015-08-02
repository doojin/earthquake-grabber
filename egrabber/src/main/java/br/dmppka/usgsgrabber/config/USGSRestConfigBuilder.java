package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.RequestType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class USGSRestConfigBuilder {

    public static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";

    private RequestType requestType;
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
        config.setRequestType(requestType);
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

    public USGSRestConfigBuilder withRequestType(RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    public USGSRestConfigBuilder withStartTime(Calendar startTime) {
        this.startTime = startTime;
        return this;
    }

    public USGSRestConfigBuilder withStartTime(String startTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date date = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
        calendar.setTime(date);
        this.startTime = calendar;
        return this;
    }

    public USGSRestConfigBuilder withEndTime(Calendar endTime) {
        this.endTime = endTime;
        return this;
    }

    public USGSRestConfigBuilder withEndTime(String endTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date date = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
        calendar.setTime(date);
        this.endTime = calendar;
        return this;
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