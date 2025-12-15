package com.wqs.app.dto;

public class DashboardSummaryResponse {

    private long good;
    private long moderate;
    private long poor;

    public DashboardSummaryResponse() {}

    public DashboardSummaryResponse(long good, long moderate, long poor) {
        this.good = good;
        this.moderate = moderate;
        this.poor = poor;
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
