package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Refueling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefuelingRepository extends JpaRepository<Refueling, Integer> {

    @Query("SELECT r FROM Refueling r WHERE r.id_car = ?1")
    List<Refueling> findRefuelingsFromCar(Integer id_car);
}
