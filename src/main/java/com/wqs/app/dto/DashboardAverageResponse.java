package com.wqs.app.dto;

public class DashboardAverageResponse {

    private double avgPh;
    private double avgTurbidity;
    private double avgTds;
    private double avgTemperature;

    public DashboardAverageResponse() {}

    public DashboardAverageResponse(double avgPh, double avgTurbidity,
                                    double avgTds, double avgTemperature) {
        this.avgPh = avgPh;
        this.avgTurbidity = avgTurbidity;
        this.avgTds = avgTds;
        this.avgTemperature = avgTemperature;
    }

    public double getAvgPh() {
        return avgPh;
    }

    public void setAvgPh(double avgPh) {
        this.avgPh = avgPh;
    }

    public double getAvgTurbidity() {
        return avgTurbidity;
    }

    public void setAvgTurbidity(double avgTurbidity) {
        this.avgTurbidity = avgTurbidity;
    }

    public double getAvgTds() {
        return avgTds;
    }

    public void setAvgTds(double avgTds) {
        this.avgTds = avgTds;
    }

    public double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }
}
