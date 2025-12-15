package com.wqs.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wqs.app.dto.ThresholdRequest;
import com.wqs.app.entity.ThresholdConfig;
import com.wqs.app.service.ConfigService;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private final ConfigService service;

    public ConfigController(ConfigService service) {
        this.service = service;
    }

    @GetMapping("/thresholds")
    public ThresholdConfig getThresholds() {
        return service.getThresholds();
    }
    
    @PutMapping("/thresholds")
    public ThresholdConfig updateThresholds(
            @RequestBody ThresholdRequest request) {
        return service.updateThresholds(request);
    }
    
    @PostMapping("/reset")
    public ThresholdConfig reset() {
        return service.resetThresholds();
    }

}
