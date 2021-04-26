package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE c.company = ?1")
    List<Car> findCarsFromCompany(Company company);

    @Query("SELECT f FROM Car f WHERE f.isTaken = 0")
    List<Car> findAvailableCars();

    @Query("SELECT t FROM Car t WHERE t.isTaken = 1")
    List<Car> findTakenCars();
}
