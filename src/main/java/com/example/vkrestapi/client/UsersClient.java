package com.example.vkrestapi.client;

import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.models.Todo;
import com.example.vkrestapi.models.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(url = "https://jsonplaceholder.typicode.com/users/",name="users")
@CacheConfig(cacheNames={"users"})
public interface UsersClient {
    @GetMapping
    @Cacheable
    List<User> getUsers(@SpringQueryMap Map<String,Object> params);

    @GetMapping("{userId}")
    @Cacheable
    User getUser(@PathVariable Integer userId);

    @GetMapping("{userId}/albums")
    @Cacheable
    List<Album> getUserAlbums(@PathVariable Integer userId);

    @GetMapping("{userId}/todos")
    @Cacheable
    List<Todo> getUserTodos(@PathVariable Integer userId);

    @GetMapping("{userId}/posts")
    @Cacheable
    List<Post> getUserPosts(@PathVariable Integer userId);

    @PostMapping
    User createUser(@RequestBody User user);

    @PutMapping("{userId}")
    User updateUser(@PathVariable Integer userId, @RequestBody User user);

    @PatchMapping("{userId}")
    User editUser(@PathVariable Integer userId, @RequestBody Map<String, Object> user);

    @DeleteMapping("{userId}")
    void deleteUser(@PathVariable Integer userId);

}
