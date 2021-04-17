package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Refueling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefuelingRepository extends JpaRepository<Refueling, Integer> {
}
