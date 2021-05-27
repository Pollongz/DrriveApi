package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Report;
import com.drrive.DrriveApi.rest.CarRepository;
import com.drrive.DrriveApi.rest.ReportRepository;
import com.drrive.DrriveApi.rest.UsersDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    
    private final ReportRepository reportRepository;
    private final CarRepository carRepository;
    private final UsersDataRepository usersDataRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository, CarRepository carRepository, UsersDataRepository usersDataRepository) {
        this.reportRepository = reportRepository;
        this.carRepository = carRepository;
        this.usersDataRepository = usersDataRepository;
    }

    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Integer idReport) {
        return reportRepository.findById(idReport)
                .orElseThrow(() -> new IllegalStateException(
                        "Report with id: " + idReport + "doesn't exist."
                ));
    }

    public void addNewReport(Report report) {
        report.setCar(carRepository.getOne(report.getIdCar()));
        report.setUsersData(usersDataRepository.getOne(report.getIdUsersData()));
        reportRepository.save(report);
    }

    public String deleteReport(Integer idReport) {
        boolean exists = reportRepository.existsById(idReport);
        if (!exists) {
            throw new IllegalStateException("Report with id: " + idReport + "doesn't exist.");
        }

        reportRepository.deleteById(idReport);
        return "Report deleted successfully!";
    }

    public String updateReport(Report report) {
        Report existingReport = reportRepository.findById(report.getIdReport())
                .orElseThrow(() -> new IllegalStateException(
                        "Report with id: " + report.getIdReport() + "doesn't exist."
                ));
        existingReport.setMileage(report.getMileage());
        existingReport.setDateTime(report.getDateTime());
        report.setCar(carRepository.getOne(report.getIdCar()));
        report.setUsersData(usersDataRepository.getOne(report.getIdUsersData()));

        reportRepository.save(existingReport);
        return "Report edited successfully!";
    }
}
