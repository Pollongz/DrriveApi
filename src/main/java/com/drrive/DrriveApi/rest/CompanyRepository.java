package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "companies", path = "company")
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
}
