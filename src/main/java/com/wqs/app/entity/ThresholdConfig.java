package com.wqs.app.entity;

import jakarta.persistence.*;

@Entity
public class ThresholdConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double phMin;
    private double phMax;
    private double turbidityMax;
    private double tdsMax;

    public ThresholdConfig() {}

    public Long getId() {
        return id;
    }

    public double getPhMin() {
        return phMin;
    }

    public void setPhMin(double phMin) {
        this.phMin = phMin;
    }

    public double getPhMax() {
        return phMax;
    }

    public void setPhMax(double phMax) {
        this.phMax = phMax;
    }

    public double getTurbidityMax() {
        return turbidityMax;
    }

    public void setTurbidityMax(double turbidityMax) {
        this.turbidityMax = turbidityMax;
    }

    public double getTdsMax() {
        return tdsMax;
    }

    public void setTdsMax(double tdsMax) {
        this.tdsMax = tdsMax;
    }
}
