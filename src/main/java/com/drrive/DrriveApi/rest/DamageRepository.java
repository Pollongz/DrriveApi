package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageRepository extends JpaRepository<Damage, Integer> {
}