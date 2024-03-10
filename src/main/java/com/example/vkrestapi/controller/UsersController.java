package com.example.vkrestapi.controller;

import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.models.Todo;
import com.example.vkrestapi.models.User;
import com.example.vkrestapi.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public List<User> getUsers() {
        return usersService.getUsers();
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
}
