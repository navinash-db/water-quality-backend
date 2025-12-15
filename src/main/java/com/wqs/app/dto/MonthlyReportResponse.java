package com.wqs.app.dto;

public class MonthlyReportResponse {

    private String month;
    private long totalReadings;
    private long good;
    private long moderate;
    private long poor;
    private double avgPh;
    private double avgTurbidity;
    private double avgTds;
    private double avgTemperature;

    public MonthlyReportResponse() {}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public long getTotalReadings() {
		return totalReadings;
	}

	public void setTotalReadings(long totalReadings) {
		this.totalReadings = totalReadings;
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

    // getters and setters (generate normally)
    
    
}
