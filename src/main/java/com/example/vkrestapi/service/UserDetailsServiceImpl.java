package com.example.vkrestapi.service;

import com.example.vkrestapi.repository.UserDetailsRepository;
import com.example.vkrestapi.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetailsImpl> credential = repository.findByUsername(username);
        return credential.orElseThrow(
                () -> new UsernameNotFoundException(username)
        );
    }
}
