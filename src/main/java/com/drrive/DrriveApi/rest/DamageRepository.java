package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Damage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "damages", path = "damages")
public interface DamageRepository extends PagingAndSortingRepository<Damage, Integer> {
}