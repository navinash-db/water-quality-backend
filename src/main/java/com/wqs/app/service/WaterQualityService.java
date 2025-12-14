package com.wqs.app.service;

import com.wqs.app.dto.WaterQualityResponse;

public interface WaterQualityService {

    WaterQualityResponse evaluate(Long readingId);
    
    String getStatus(Long readingId);
    
    String getRemarks(Long readingId);


}
