package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.UsersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}