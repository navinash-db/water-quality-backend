package com.wqs.app.service;

import java.time.LocalDate;
import java.time.YearMonth;

import com.wqs.app.dto.DailyReportResponse;
import com.wqs.app.dto.MonthlyReportResponse;

public interface ReportService {

    DailyReportResponse getDailyReport(LocalDate date);
    MonthlyReportResponse getMonthlyReport(YearMonth month);
    
    String exportDailyCsv(LocalDate date);

    String exportMonthlyCsv(YearMonth month);

}
