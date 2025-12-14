package com.wqs.app.dto;

public class DailyReportResponse {

    private String date;
    private long totalReadings;
    private long good;
    private long moderate;
    private long poor;
    private double avgPh;
    private double avgTurbidity;
    private double avgTds;
    private double avgTemperature;

    public DailyReportResponse() {}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public DailyReportResponse(String date, long totalReadings, long good, long moderate, long poor, double avgPh,
			double avgTurbidity, double avgTds, double avgTemperature) {
		super();
		this.date = date;
		this.totalReadings = totalReadings;
		this.good = good;
		this.moderate = moderate;
		this.poor = poor;
		this.avgPh = avgPh;
		this.avgTurbidity = avgTurbidity;
		this.avgTds = avgTds;
		this.avgTemperature = avgTemperature;
	}

    // getters and setters (generate normally)
    
}
