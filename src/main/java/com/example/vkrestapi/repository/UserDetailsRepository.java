package com.example.vkrestapi.repository;

import com.example.vkrestapi.security.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsImpl,Integer> {
    Optional<UserDetailsImpl> findByUsername(String username);
    boolean existsByUsername(String username);
}
