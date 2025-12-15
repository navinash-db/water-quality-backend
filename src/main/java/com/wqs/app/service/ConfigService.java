package com.wqs.app.service;

import com.wqs.app.dto.ThresholdRequest;
import com.wqs.app.entity.ThresholdConfig;

public interface ConfigService {

    ThresholdConfig getThresholds();
    ThresholdConfig updateThresholds(ThresholdRequest request);
    ThresholdConfig resetThresholds();
}
