package com.drrive.DrriveApi.service;

import com.drrive.DrriveApi.entity.Car;
import com.drrive.DrriveApi.entity.Company;
import com.drrive.DrriveApi.entity.Post;
import com.drrive.DrriveApi.rest.CompanyRepository;
import com.drrive.DrriveApi.rest.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public PostService(PostRepository postRepository, CompanyRepository companyRepository) {
        this.postRepository = postRepository;
        this.companyRepository = companyRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer idPost) {
        return postRepository.findById(idPost)
                .orElseThrow(() -> new IllegalStateException(
                        "Post with id: " + idPost + "doesn't exist."
                ));
    }

    public List<Post> getCompanyPosts(Company company) {
        return postRepository.findPostsFromCompany(company);
    }

    public Post addNewPost(Post post) {
        post.setCompany(companyRepository.getOne(post.getCompanyId()));
        return postRepository.save(post);
    }

    public String deletePost(Integer idPost) {
        boolean exists = postRepository.existsById(idPost);
        if (!exists) {
            throw new IllegalStateException("Post with id: " + idPost + "doesn't exist.");
        }
        postRepository.deleteById(idPost);

        return "Posts deleted successfully!";
    }

    public Post updatePost(Post post) {
        Post existingPost = postRepository.findById(post.getIdPost())
                .orElseThrow(() -> new IllegalStateException(
                        "Post with id: " + post.getIdPost() + "doesn't exist."
                ));
        existingPost.setTitle(post.getTitle());
        existingPost.setDescription(post.getDescription());
        existingPost.setDate(post.getDate());
        existingPost.setCompany(companyRepository.getOne(post.getCompanyId()));

        return postRepository.save(existingPost);
    }
}
