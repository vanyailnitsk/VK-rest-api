package com.example.vkrestapi.controller;

import com.example.vkrestapi.dao.UserDetailsImpl;
import com.example.vkrestapi.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-details")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserDetailsController {
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping
    public UserDetailsImpl createUser(@RequestBody UserDetailsImpl userDetails) {
        return userDetailsService.createUser(userDetails);
    }

    @GetMapping("{userId}")
    public UserDetailsImpl getUser(@PathVariable Integer userId) {
        return userDetailsService.getUser(userId);
    }
}
