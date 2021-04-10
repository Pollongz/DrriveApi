package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.UserData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users-data", path = "users-data")
public interface UserDataRepository extends PagingAndSortingRepository<UserData, Integer> {
}