package com.wqs.app.dto;

public class WaterQualityResponse {

    private String quality;
    private String remarks;

    public WaterQualityResponse() {}

    public WaterQualityResponse(String quality, String remarks) {
        this.quality = quality;
        this.remarks = remarks;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
