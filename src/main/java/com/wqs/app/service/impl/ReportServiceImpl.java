package com.wqs.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wqs.app.dto.DailyReportResponse;
import com.wqs.app.dto.MonthlyReportResponse;
import com.wqs.app.entity.WaterReading;
import com.wqs.app.repository.WaterReadingRepository;
import com.wqs.app.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    private final WaterReadingRepository repo;

    public ReportServiceImpl(WaterReadingRepository repo) {
        this.repo = repo;
    }

    @Override
    public DailyReportResponse getDailyReport(LocalDate date) {

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);

        List<WaterReading> readings =
            repo.findByTimestampBetween(start, end);

        DailyReportResponse report = new DailyReportResponse();
        report.setDate(date.toString());
        report.setTotalReadings(readings.size());

        long good = 0, moderate = 0, poor = 0;
        double ph = 0, turbidity = 0, tds = 0, temp = 0;

        for (WaterReading r : readings) {
            ph += r.getPh();
            turbidity += r.getTurbidity();
            tds += r.getTds();
            temp += r.getTemperature();

            if ("Good".equals(r.getQuality())) good++;
            else if ("Moderate".equals(r.getQuality())) moderate++;
            else if ("Poor".equals(r.getQuality())) poor++;
        }

        int count = readings.size();
        if (count > 0) {
            report.setAvgPh(ph / count);
            report.setAvgTurbidity(turbidity / count);
            report.setAvgTds(tds / count);
            report.setAvgTemperature(temp / count);
        }

        report.setGood(good);
        report.setModerate(moderate);
        report.setPoor(poor);

        return report;
    }
    
  

    @Override
    public MonthlyReportResponse getMonthlyReport(YearMonth month) {

        LocalDateTime start = month.atDay(1).atStartOfDay();
        LocalDateTime end = month.atEndOfMonth().atTime(23, 59, 59);

        List<WaterReading> readings =
            repo.findByTimestampBetween(start, end);

        MonthlyReportResponse report = new MonthlyReportResponse();
        report.setMonth(month.toString());
        report.setTotalReadings(readings.size());

        long good = 0, moderate = 0, poor = 0;
        double ph = 0, turbidity = 0, tds = 0, temp = 0;

        for (WaterReading r : readings) {
            ph += r.getPh();
            turbidity += r.getTurbidity();
            tds += r.getTds();
            temp += r.getTemperature();

            if ("Good".equals(r.getQuality())) good++;
            else if ("Moderate".equals(r.getQuality())) moderate++;
            else if ("Poor".equals(r.getQuality())) poor++;
        }

        int count = readings.size();
        if (count > 0) {
            report.setAvgPh(ph / count);
            report.setAvgTurbidity(turbidity / count);
            report.setAvgTds(tds / count);
            report.setAvgTemperature(temp / count);
        }

        report.setGood(good);
        report.setModerate(moderate);
        report.setPoor(poor);

        return report;
    }
    
    @Override
    public String exportDailyCsv(LocalDate date) {

        DailyReportResponse r = getDailyReport(date);

        return "Date,Total,Good,Moderate,Poor,AvgPH,AvgTurbidity,AvgTDS,AvgTemperature\n" +
               r.getDate() + "," +
               r.getTotalReadings() + "," +
               r.getGood() + "," +
               r.getModerate() + "," +
               r.getPoor() + "," +
               r.getAvgPh() + "," +
               r.getAvgTurbidity() + "," +
               r.getAvgTds() + "," +
               r.getAvgTemperature();
    }

    @Override
    public String exportMonthlyCsv(YearMonth month) {

        MonthlyReportResponse r = getMonthlyReport(month);

        return "Month,Total,Good,Moderate,Poor,AvgPH,AvgTurbidity,AvgTDS,AvgTemperature\n" +
               r.getMonth() + "," +
               r.getTotalReadings() + "," +
               r.getGood() + "," +
               r.getModerate() + "," +
               r.getPoor() + "," +
               r.getAvgPh() + "," +
               r.getAvgTurbidity() + "," +
               r.getAvgTds() + "," +
               r.getAvgTemperature();
    }


}
