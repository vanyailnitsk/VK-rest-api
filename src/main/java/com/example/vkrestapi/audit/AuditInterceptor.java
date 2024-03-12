package com.example.vkrestapi.audit;

import com.example.vkrestapi.security.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class AuditInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        List<String> params = request.getParameterMap().entrySet().stream().map(
                pair -> pair.getKey()+"="+pair.getValue()[0]).toList();
        boolean hasAccess = hasAccessToController(authentication.getAuthorities(),uri);
        log.info("Username: {}, Roles: {} ,Has access: {}, Method: {}, URI: {}, Params: {}",
                username,authentication.getAuthorities(), hasAccess,method, uri, params);
        return true;
    }

    public boolean hasAccessToController(Collection<? extends GrantedAuthority> roles, String uri) {
        Set<Role> needed;
        if (uri.startsWith("/api/posts")) {
            needed = Set.of(Role.ROLE_POSTS, Role.ROLE_ADMIN);
        } else if (uri.startsWith("/api/users")) {
            needed = Set.of(Role.ROLE_USERS, Role.ROLE_ADMIN);
        } else if (uri.startsWith("/api/albums")) {
            needed = Set.of(Role.ROLE_ALBUMS, Role.ROLE_ADMIN);
        } else {
            needed = Set.of();
        }
        for (GrantedAuthority role : roles) {
            if (needed.contains(role)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
    }
}
