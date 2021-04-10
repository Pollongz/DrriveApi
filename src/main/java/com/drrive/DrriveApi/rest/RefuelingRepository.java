package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Refueling;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "refuelings", path = "refuelings")
public interface RefuelingRepository extends PagingAndSortingRepository<Refueling, Integer> {
}
