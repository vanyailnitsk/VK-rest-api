package com.example.vkrestapi.client;

import com.example.vkrestapi.models.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(url = "https://jsonplaceholder.typicode.com/posts/",name="posts")
@CacheConfig(cacheNames={"posts"})
public interface PostsClient {
    @GetMapping
    @Cacheable
    List<Post> getPosts(@SpringQueryMap Map<String,Object> params);

    @GetMapping("{postId}")
    @Cacheable
    Post getPost(@PathVariable Integer postId);

    @GetMapping("{postId}/comments")
    @Cacheable
    List<Comment> getPostComments(@PathVariable Integer postId);

    @PostMapping
    Post createPost(@RequestBody Post post);

    @PutMapping("{postId}")
    Post updatePost(@PathVariable Integer postId, @RequestBody Post post);

    @PatchMapping("{postId}")
    Post editPost(@PathVariable Integer postId, @RequestBody Map<String, Object> post);

    @DeleteMapping("{postId}")
    void deletePost(@PathVariable Integer postId);
}
