package com.wqs.app.controller;

import java.time.LocalDate;
import java.time.YearMonth;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wqs.app.dto.DailyReportResponse;
import com.wqs.app.dto.MonthlyReportResponse;
import com.wqs.app.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/daily")
    public DailyReportResponse dailyReport(
        @RequestParam
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate date) {

        return service.getDailyReport(date);
    }
    
    @GetMapping("/monthly")
    public MonthlyReportResponse monthlyReport(
        @RequestParam
        @DateTimeFormat(pattern = "yyyy-MM")
        YearMonth month) {

        return service.getMonthlyReport(month);
    }
    
    @GetMapping("/export")
    public String export(
        @RequestParam String type,
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String month,
        @RequestParam(defaultValue = "csv") String format) {

        if ("daily".equalsIgnoreCase(type)) {
            return service.exportDailyCsv(LocalDate.parse(date));
        }

        if ("monthly".equalsIgnoreCase(type)) {
            return service.exportMonthlyCsv(YearMonth.parse(month));
        }

        return "Invalid export request";
    }

}