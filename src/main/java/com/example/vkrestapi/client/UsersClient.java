package com.example.vkrestapi.client;

import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.models.Todo;
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
    List<Album> getUserAlbums(@PathVariable Integer userId);

    @GetMapping("{userId}/todos")
    List<Todo> getTodos(@PathVariable Integer userId);

    @GetMapping("{userId}/posts")
    List<Post> getUserPosts(@PathVariable Integer userId);

}
