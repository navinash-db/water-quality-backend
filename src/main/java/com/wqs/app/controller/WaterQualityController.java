package com.wqs.app.controller;

import org.springframework.web.bind.annotation.*;

import com.wqs.app.dto.WaterQualityResponse;
import com.wqs.app.service.WaterQualityService;

@RestController
@RequestMapping("/api/water-quality")
public class WaterQualityController {

    private final WaterQualityService service;

    public WaterQualityController(WaterQualityService service) {
        this.service = service;
    }

    @GetMapping("/evaluate/{readingId}")
    public WaterQualityResponse evaluate(@PathVariable Long readingId) {
        return service.evaluate(readingId);
    }
    
    @GetMapping("/status/{readingId}")
    public String getStatus(@PathVariable Long readingId) {
        return service.getStatus(readingId);
    }
    
    @GetMapping("/remarks/{readingId}")
    public String getRemarks(@PathVariable Long readingId) {
        return service.getRemarks(readingId);
    }


}
