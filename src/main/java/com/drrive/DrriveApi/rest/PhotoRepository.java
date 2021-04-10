package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Photo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "photos", path = "photos")
public interface PhotoRepository extends PagingAndSortingRepository<Photo, Integer> {
}


