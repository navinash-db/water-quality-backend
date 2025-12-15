package com.wqs.app.service.impl;

import org.springframework.stereotype.Service;

import com.wqs.app.dto.WaterQualityResponse;
import com.wqs.app.entity.WaterReading;
import com.wqs.app.repository.WaterReadingRepository;
import com.wqs.app.service.WaterQualityService;

@Service
public class WaterQualityServiceImpl implements WaterQualityService {

    private final WaterReadingRepository repo;

    public WaterQualityServiceImpl(WaterReadingRepository repo) {
        this.repo = repo;
    }

    @Override
    public WaterQualityResponse evaluate(Long id) {

        WaterReading r = repo.findById(id).orElse(null);

        if (r == null) {
            return new WaterQualityResponse("UNKNOWN", "Reading not found");
        }

        String quality = "Good";
        String remarks = "Water is safe for use";

        if (r.getPh() < 6 || r.getPh() > 8) {
            quality = "Poor";
            remarks = "pH value out of acceptable range";
        } else if (r.getTurbidity() > 5) {
            quality = "Poor";
            remarks = "High turbidity detected";
        } else if (r.getTds() > 500) {
            quality = "Moderate";
            remarks = "TDS slightly above recommended level";
        }

        return new WaterQualityResponse(quality, remarks);
    }
    
    @Override
    public String getStatus(Long readingId) {

        WaterReading r = repo.findById(readingId).orElse(null);

        if (r == null) {
            return "UNKNOWN";
        }

        if (r.getPh() < 6 || r.getPh() > 8) return "Poor";
        if (r.getTurbidity() > 5) return "Poor";
        if (r.getTds() > 500) return "Moderate";

        return "Good";
    }

    
    @Override
    public String getRemarks(Long readingId) {

        WaterReading r = repo.findById(readingId).orElse(null);

        if (r == null) {
            return "Reading not found";
        }

        if (r.getPh() < 6 || r.getPh() > 8) {
            return "pH value out of acceptable range";
        }

        if (r.getTurbidity() > 5) {
            return "High turbidity detected";
        }

        if (r.getTds() > 500) {
            return "TDS slightly above recommended level";
        }

        return "Water is safe for use";
    }

}
