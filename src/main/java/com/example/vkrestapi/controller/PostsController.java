package com.example.vkrestapi.controller;

import com.example.vkrestapi.models.Comment;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USERS') or hasRole('ROLE_ADMIN')")
public class PostsController {
    private final PostsService postsService;

    @GetMapping
    public List<Post> getPosts(@RequestParam Map<String,Object> params) {
        return postsService.getPosts(params);
    }

    @GetMapping("{postId}")
    public Post getPost(@PathVariable Integer postId) {
        return postsService.getPost(postId);
    }

    @GetMapping("{postId}/comments")
    public List<Comment> getPostComments(@PathVariable Integer postId) {
        return postsService.getPostComments(postId);
    }

    @PostMapping
    public  Post createPost(@RequestBody Post post) {
        return postsService.createPost(post);
    }

    @PutMapping("{postId}")
    public Post updatePost(@PathVariable Integer postId, @RequestBody Post post) {
        return postsService.updatePost(postId,post);
    }

    @PatchMapping("{postId}")
    public Post editPost(@PathVariable Integer postId, @RequestBody Map<String, Object> post) {
        return postsService.editPost(postId,post);
    }

    @DeleteMapping("{postId}")
    public void deletePost(@PathVariable Integer postId) {
        postsService.deletePost(postId);
    }
}
