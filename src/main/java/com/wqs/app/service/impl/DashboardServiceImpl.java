package com.wqs.app.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wqs.app.dto.DashboardAverageResponse;
import com.wqs.app.dto.DashboardSummaryResponse;
import com.wqs.app.dto.DashboardTrendResponse;
import com.wqs.app.entity.WaterReading;
import com.wqs.app.repository.WaterReadingRepository;
import com.wqs.app.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final WaterReadingRepository repo;

    public DashboardServiceImpl(WaterReadingRepository repo) {
        this.repo = repo;
    }

    @Override
    public WaterReading getLatestReading() {
        return repo.findTopByOrderByTimestampDesc().orElse(null);
    }
    
    @Override
    public DashboardSummaryResponse getSummary() {

        long good = repo.countByQuality("Good");
        long moderate = repo.countByQuality("Moderate");
        long poor = repo.countByQuality("Poor");

        return new DashboardSummaryResponse(good, moderate, poor);
    }
    
    @Override
    public DashboardAverageResponse getAverage() {

        Double ph = repo.avgPh();
        Double turbidity = repo.avgTurbidity();
        Double tds = repo.avgTds();
        Double temperature = repo.avgTemperature();

        return new DashboardAverageResponse(
            ph != null ? ph : 0.0,
            turbidity != null ? turbidity : 0.0,
            tds != null ? tds : 0.0,
            temperature != null ? temperature : 0.0
        );
    }
    
    @Override
    public List<DashboardTrendResponse> getTrends() {

        List<WaterReading> readings = repo.findAllByOrderByTimestampAsc();
        Map<LocalDate, DashboardTrendResponse> map = new LinkedHashMap<>();

        for (WaterReading r : readings) {

            LocalDate date = r.getTimestamp().toLocalDate();

            map.putIfAbsent(date,
                new DashboardTrendResponse(date.toString(), 0, 0, 0));

            DashboardTrendResponse trend = map.get(date);

            if ("Good".equals(r.getQuality())) {
                trend.setGood(trend.getGood() + 1);
            } else if ("Moderate".equals(r.getQuality())) {
                trend.setModerate(trend.getModerate() + 1);
            } else if ("Poor".equals(r.getQuality())) {
                trend.setPoor(trend.getPoor() + 1);
            }
        }

        return new ArrayList<>(map.values());
    }

}
