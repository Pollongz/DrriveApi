package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDataRepository extends JpaRepository<UsersData, Integer> {

    @Query("SELECT e FROM UsersData e WHERE e.company = ?1")
    List<UsersData> findEmployeesFromCompany(Company company);

    @Query("SELECT u FROM UsersData u WHERE u.user= ?1")
    UsersData findUsersData(User user);
}