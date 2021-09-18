package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.*;
import com.drrive.DrriveApi.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/reports")
public class ReportController {
    
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(path = "/{idReport}")
    public Report getOneReport(@PathVariable Integer idReport) {
        return reportService.getReportById(idReport);
    }

    @GetMapping
    public List<Report> getReportsFromTo(@RequestParam("from_date")
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from_date,
                                         @RequestParam("to_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                         LocalDateTime to_date) {

        return reportService.getReportsFromTo(from_date, to_date);
    }

    @PostMapping
    public Report addNewReport(@RequestBody Report report) {
        return reportService.addNewReport(report);
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
