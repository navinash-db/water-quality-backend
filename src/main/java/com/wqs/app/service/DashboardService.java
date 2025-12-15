package com.wqs.app.service;

import java.util.List;

import com.wqs.app.dto.DashboardAverageResponse;
import com.wqs.app.dto.DashboardSummaryResponse;
import com.wqs.app.dto.DashboardTrendResponse;
import com.wqs.app.entity.WaterReading;

public interface DashboardService {

    WaterReading getLatestReading();
    
    DashboardSummaryResponse getSummary();
    
    DashboardAverageResponse getAverage();
    
    List<DashboardTrendResponse> getTrends();
}
