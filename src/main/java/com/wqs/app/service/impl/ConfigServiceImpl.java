package com.wqs.app.service.impl;

import org.springframework.stereotype.Service;

import com.wqs.app.dto.ThresholdRequest;
import com.wqs.app.entity.ThresholdConfig;
import com.wqs.app.repository.ThresholdConfigRepository;
import com.wqs.app.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

    private final ThresholdConfigRepository repo;

    public ConfigServiceImpl(ThresholdConfigRepository repo) {
        this.repo = repo;
    }

    @Override
    public ThresholdConfig getThresholds() {
        // assume single row config
        return repo.findAll().stream().findFirst().orElse(null);
    }
    
    @Override
    public ThresholdConfig updateThresholds(ThresholdRequest request) {

        ThresholdConfig config =
            repo.findAll().stream().findFirst().orElse(new ThresholdConfig());

        config.setPhMin(request.getPhMin());
        config.setPhMax(request.getPhMax());
        config.setTurbidityMax(request.getTurbidityMax());
        config.setTdsMax(request.getTdsMax());

        return repo.save(config);
    }
    
    @Override
    public ThresholdConfig resetThresholds() {

        ThresholdConfig config =
            repo.findAll().stream().findFirst().orElse(new ThresholdConfig());

        // Default values
        config.setPhMin(6.5);
        config.setPhMax(8.5);
        config.setTurbidityMax(5.0);
        config.setTdsMax(500.0);

        return repo.save(config);
    }

}
