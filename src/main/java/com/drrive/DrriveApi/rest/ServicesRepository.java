package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

    @Query("SELECT s FROM Services s WHERE s.car = ?1")
    List<Services> findServicesFromCar(Car car);

    @Query("SELECT s FROM Services s WHERE s.car = :car and s.date between :from_date and :to_date")
    List<Services> findServicesFromCarFromTo(@Param("car") Car car, @Param("from_date") Date from_date, @Param("to_date") Date to_date);
}