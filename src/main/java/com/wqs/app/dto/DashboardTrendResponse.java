package com.wqs.app.dto;

public class DashboardTrendResponse {

    private String date;
    private long good;
    private long moderate;
    private long poor;

    public DashboardTrendResponse() {}

    public DashboardTrendResponse(String date, long good, long moderate, long poor) {
        this.date = date;
        this.good = good;
        this.moderate = moderate;
        this.poor = poor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getGood() {
        return good;
    }

    public void setGood(long good) {
        this.good = good;
    }

    public long getModerate() {
        return moderate;
    }

    public void setModerate(long moderate) {
        this.moderate = moderate;
    }

    public long getPoor() {
        return poor;
    }

    public void setPoor(long poor) {
        this.poor = poor;
    }
}
