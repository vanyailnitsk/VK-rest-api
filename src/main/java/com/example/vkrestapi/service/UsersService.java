package com.example.vkrestapi.service;

import com.example.vkrestapi.client.UsersClient;
import com.example.vkrestapi.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersClient usersClient;

    public List<User> getUsers() {
        return usersClient.getUsers();
    }
}
