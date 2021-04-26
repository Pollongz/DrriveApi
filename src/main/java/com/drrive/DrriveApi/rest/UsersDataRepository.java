package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.UsersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDataRepository extends JpaRepository<UsersData, Integer> {

    @Query("SELECT e FROM UsersData e WHERE e.company = ?1")
    List<UsersData> findEmployeesFromCompany(Company company);
}