package com.example.vkrestapi.security;

import com.example.vkrestapi.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
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
