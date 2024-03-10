package com.example.vkrestapi.service;

import com.example.vkrestapi.client.UsersClient;
import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.models.Todo;
import com.example.vkrestapi.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersClient usersClient;

    public List<User> getUsers() {
        return usersClient.getUsers();
    }
    public User getUser(@PathVariable Integer userId) {
        return usersClient.getUser(userId);
    }

    public List<Album> getUserAlbums(@PathVariable Integer userId) {
        return usersClient.getUserAlbums(userId);
    }

   public List<Todo> getUserTodos(@PathVariable Integer userId) {
        return usersClient.getUserTodos(userId);
   }

    public List<Post> getUserPosts(@PathVariable Integer userId) {
        return usersClient.getUserPosts(userId);
    }
}
