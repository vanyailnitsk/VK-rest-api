package com.example.vkrestapi.controller;

import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.models.Todo;
import com.example.vkrestapi.models.User;
import com.example.vkrestapi.service.UsersService;
import feign.QueryMap;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USERS') or hasRole('ROLE_ADMIN')")
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public List<User> getUsers(@RequestParam Map<String,Object> params) {
        return usersService.getUsers(params);
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable Integer userId) {
        return usersService.getUser(userId);
    }

    @GetMapping("{userId}/albums")
    public List<Album> getUserAlbums(@PathVariable Integer userId) {
        return usersService.getUserAlbums(userId);
    }

    @GetMapping("{userId}/todos")
    public List<Todo> getUserTodos(@PathVariable Integer userId) {
        return usersService.getUserTodos(userId);
    }

    @GetMapping("{userId}/posts")
    public List<Post> getUserPosts(@PathVariable Integer userId) {
        return usersService.getUserPosts(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        return usersService.createUser(user);
    }

    @PutMapping("{userId}")
    public User updateUser(@PathVariable Integer userId,@RequestBody  User user) {
        return usersService.updateUser(userId,user);
    }

    @PatchMapping("{userId}")
    public User editUser(@PathVariable Integer userId, @RequestBody Map<String, Object> user) {
        return usersService.editUser(userId,user);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        usersService.deleteUser(userId);
    }
}
