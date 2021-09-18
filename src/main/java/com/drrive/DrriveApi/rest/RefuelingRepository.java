package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Refueling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RefuelingRepository extends JpaRepository<Refueling, Integer> {

    @Query("SELECT r FROM Refueling r WHERE r.car = ?1")
    List<Refueling> findRefuelingsFromCar(Car car);

    @Query("SELECT r FROM Refueling r WHERE r.car = :car and r.date between :from_date and :to_date")
    List<Refueling> findRefuelingsFromCarFromTo(@Param("car") Car car, @Param("from_date") Date from_date, @Param("to_date") Date to_date);
}
