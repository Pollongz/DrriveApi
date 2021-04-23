package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Damage;
import com.drrive.DrriveApi.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    @Query("SELECT p FROM Photo p WHERE p.id_damage = ?1")
    List<Photo> findPhotosFromDamage(Integer id_damage);
}


