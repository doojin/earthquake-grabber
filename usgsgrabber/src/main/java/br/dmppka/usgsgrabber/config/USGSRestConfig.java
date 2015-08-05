package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.ResponseFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class USGSRestConfig {

    public static final DateFormat ISO8601 =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

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

    public String getResponseFormatValue() {
        return responseFormat == null ? null : responseFormat.getValue();
    }

    public ResponseFormat getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(ResponseFormat responseFormat) {
        this.responseFormat = responseFormat;
    }

    public String getStartTime() {
        return startTime == null ? null : ISO8601.format(startTime.getTime());
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime == null ? null : ISO8601.format(endTime.getTime());
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getMinMagnitude() {
        return minMagnitude;
    }

    public void setMinMagnitude(double minMagnitude) {
        this.minMagnitude = minMagnitude;
    }

    public double getMaxMagnitude() {
        return maxMagnitude;
    }

    public void setMaxMagnitude(double maxMagnitude) {
        this.maxMagnitude = maxMagnitude;
    }
}