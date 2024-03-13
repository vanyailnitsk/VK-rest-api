package com.example.vkrestapi.service;

import com.example.vkrestapi.repository.UserDetailsRepository;
import com.example.vkrestapi.dao.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetailsImpl> credential = userDetailsRepository.findByUsername(username);
        return credential.orElseThrow(
                () -> new UsernameNotFoundException(username)
        );
    }

    public UserDetailsImpl createUser(UserDetailsImpl userDetails) {
        if (userDetailsRepository.existsByUsername(userDetails.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Username уже занят!");
        }
        userDetails.setPassword(new BCryptPasswordEncoder(8).encode(userDetails.getPassword()));
        return userDetailsRepository.save(userDetails);
    }

    public UserDetailsImpl getUser(Integer userId) {
        return userDetailsRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User с id "+userId+" не найден"));
    }
}
