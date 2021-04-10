package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {
}
