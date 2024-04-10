package com.example.courseapi.filter;

import com.example.courseapi.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!isAuthRequired(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace("Bearer ", "");

        if (userService.isAuthorized(token)) {
            filterChain.doFilter(request, response);
        }
    }

    private boolean isAuthRequired(HttpServletRequest request) {
        String requestUri = request.getRequestURI();

        String[] pathsRequiringAuthorization = {
                "/users/find/"
                ,"/users/add"
                ,"/users/change-username"
                ,"/users/change-password"
                ,"/users/change-personal-information"
        };

        boolean requiresAuthorization = false;
        for (String path: pathsRequiringAuthorization) {
            if (requestUri.contains(path)) {
                requiresAuthorization = true;
                break;
            }
        }
        return requiresAuthorization;
    }

}
