package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDataRepository extends JpaRepository<LoginData, Integer> {

    Optional<LoginData> findUserByEmail(String email);
}