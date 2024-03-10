package com.example.vkrestapi.service;

import com.example.vkrestapi.client.UsersClient;
import com.example.vkrestapi.models.Album;
import com.example.vkrestapi.models.Post;
import com.example.vkrestapi.models.Todo;
import com.example.vkrestapi.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

    public User createUser(User user) {
        return usersClient.createUser(user);
    }

    public User updateUser(Integer userId, User user) {
        return usersClient.updateUser(userId,user);
    }

    public User editUser(Integer userId, User user) {
        return usersClient.editUser(userId,user);
    }

    public void deleteUser(Integer userId) {
        usersClient.deleteUser(userId);
    }
}
