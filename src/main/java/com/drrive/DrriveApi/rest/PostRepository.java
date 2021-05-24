package com.drrive.DrriveApi.rest;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.company = ?1 ORDER BY date DESC")
    List<Post> findPostsFromCompany(Company company);
}
