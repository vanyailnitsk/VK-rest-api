package com.example.vkrestapi.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://jsonplaceholder.typicode.com/posts/",name="posts")
public interface PostsClient {

}
