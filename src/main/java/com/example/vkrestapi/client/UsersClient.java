package com.example.vkrestapi.client;

import com.example.vkrestapi.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com/users/",name="users")
public interface UsersClient {
    @GetMapping
    List<User> getUsers();

    @GetMapping("{userId}")
    User getUser(@PathVariable Integer userId);

    @GetMapping("{userId}/albums")
    User getUserAlbums(@PathVariable Integer userId);

    @GetMapping("{userId}/todos")
    User getTodos(@PathVariable Integer userId);

    @GetMapping("{userId}/posts")
    User getUserPosts(@PathVariable Integer userId);

}
