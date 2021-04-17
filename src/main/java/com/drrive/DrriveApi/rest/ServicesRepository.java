package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

    @Query("SELECT s FROM Services s WHERE s.car = ?1")
    List<Services> findServicesFromCar(Car car);
}