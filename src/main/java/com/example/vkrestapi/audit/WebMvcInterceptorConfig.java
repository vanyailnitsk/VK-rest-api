package com.example.vkrestapi.audit;

import com.example.vkrestapi.dao.UserDetailsImpl;
import com.example.vkrestapi.security.Role;
import com.example.vkrestapi.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@Component
@Configuration
@RequiredArgsConstructor
public class WebMvcInterceptorConfig implements WebMvcConfigurer {
    private final AuditInterceptor auditInterceptor;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditInterceptor).excludePathPatterns("/error");
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            UserDetailsImpl postRole = UserDetailsImpl.builder()
                    .username("post")
                    .password("post")
                    .roles(Set.of(Role.ROLE_POSTS))
                    .build();
            UserDetailsImpl albumRole = UserDetailsImpl.builder()
                    .username("album")
                    .password("album")
                    .roles(Set.of(Role.ROLE_ALBUMS))
                    .build();
            UserDetailsImpl userRole = UserDetailsImpl.builder()
                    .username("user")
                    .password("user")
                    .roles(Set.of(Role.ROLE_USERS))
                    .build();
            UserDetailsImpl adminRole = UserDetailsImpl.builder()
                    .username("admin")
                    .password("admin")
                    .roles(Set.of(Role.ROLE_ADMIN))
                    .build();
            userDetailsService.createUser(postRole);
            userDetailsService.createUser(albumRole);
            userDetailsService.createUser(userRole);
            userDetailsService.createUser(adminRole);
        };
    }

}