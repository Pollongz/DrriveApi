package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT e FROM User e WHERE e.id_company = ?1")
    List<User> findEmployeesFromCompany(Integer id_company);
}