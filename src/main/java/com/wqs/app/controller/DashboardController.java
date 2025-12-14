package com.wqs.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wqs.app.dto.DashboardAverageResponse;
import com.wqs.app.dto.DashboardSummaryResponse;
import com.wqs.app.dto.DashboardTrendResponse;
import com.wqs.app.entity.WaterReading;
import com.wqs.app.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/latest")
    public WaterReading latest() {
        return service.getLatestReading();
    }
    
    @GetMapping("/summary")
    public DashboardSummaryResponse summary() {
        return service.getSummary();
    }
    
    @GetMapping("/average")
    public DashboardAverageResponse average() {
        return service.getAverage();
    }
    
    @GetMapping("/trends")
    public List<DashboardTrendResponse> trends() {
        return service.getTrends();
    }
}
