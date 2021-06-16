package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.*;
import com.drrive.DrriveApi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reports")
public class ReportController {
    
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<Report> getReport() {
        return reportService.getReports();
    }

    @GetMapping(path = "/{idReport}")
    public Report getOneReport(@PathVariable Integer idReport) {
        return reportService.getReportById(idReport);
    }

    @PostMapping
    public void addNewReport(@RequestBody Report report) {
        reportService.addNewReport(report);
    }

    @DeleteMapping(path = "/{idReport}")
    public String deleteReport(@PathVariable Integer idReport) {
        return reportService.deleteReport(idReport);
    }

    @PutMapping(path = "/{idReport}")
    public String updateReport(@RequestBody Report report) {
        return reportService.updateReport(report);
    }
}
