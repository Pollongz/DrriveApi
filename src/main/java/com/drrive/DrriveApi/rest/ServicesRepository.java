package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Services;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "services", path = "service")
public interface ServicesRepository extends PagingAndSortingRepository<Services, Integer> {
}