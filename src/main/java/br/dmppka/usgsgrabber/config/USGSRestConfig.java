package br.dmppka.usgsgrabber.config;

import br.dmppka.usgsgrabber.RequestType;

import java.util.Calendar;

public class USGSRestConfig {

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

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
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