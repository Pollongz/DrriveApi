package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.PlannedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannedServiceRepository extends JpaRepository<PlannedService, Integer> {

    @Query("SELECT l FROM PlannedService l WHERE l.car = ?1")
    List<PlannedService> findPlannedServicesFromCar(Car car);
}
