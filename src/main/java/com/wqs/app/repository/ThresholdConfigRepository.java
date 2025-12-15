package com.wqs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wqs.app.entity.ThresholdConfig;

public interface ThresholdConfigRepository
        extends JpaRepository<ThresholdConfig, Long> {
}
