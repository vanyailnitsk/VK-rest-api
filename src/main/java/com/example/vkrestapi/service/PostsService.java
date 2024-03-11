package com.example.vkrestapi.service;

import com.example.vkrestapi.client.PostsClient;
import com.example.vkrestapi.models.Comment;
import com.example.vkrestapi.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsClient postsClient;

    List<Post> getPosts(@SpringQueryMap Map<String,Object> params) {
        return postsClient.getPosts(params);
    }

    Post getPost(@PathVariable Integer postId) {
        return postsClient.getPost(postId);
    }

    List<Comment> getPostComments(@PathVariable Integer postId) {
        return postsClient.getPostComments(postId);
    }

    Post createPost(@RequestBody Post post) {
        return postsClient.createPost(post);
    }

    Post updatePost(@PathVariable Integer postId, @RequestBody Post post) {
        return postsClient.updatePost(postId,post);
    }

    Post editPost(@PathVariable Integer postId, @RequestBody Map<String, Object> post) {
        return postsClient.editPost(postId,post);
    }

    void deletePost(@PathVariable Integer postId) {
        postsClient.deletePost(postId);
    }
}
