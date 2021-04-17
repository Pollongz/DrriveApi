package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    //customized query
    List<Address> findByStreet(String city);
}


//wyszukiwanie, zeby sprawdzic czy email istnieje
//Optional<User> findUserByEmail(String email);