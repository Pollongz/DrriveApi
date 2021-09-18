package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DamageRepository extends JpaRepository<Damage, Integer> {

    @Query("SELECT d FROM Damage d WHERE d.car = ?1")
    List<Damage> findDamagesFromCar(Car car);

    @Query("SELECT d FROM Damage d WHERE d.car = :car and d.date between :from_date and :to_date")
    List<Damage> findDamagesFromCarFromTo(@Param("car") Car car, @Param("from_date") Date from_date, @Param("to_date") Date to_date);
}