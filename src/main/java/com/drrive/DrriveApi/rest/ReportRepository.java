package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query("SELECT r FROM Report r WHERE r.dateTime between :from_date and :to_date")
    List<Report> findReportsFromTo(@Param("from_date") LocalDateTime from_date, @Param("to_date") LocalDateTime to_date);
}
