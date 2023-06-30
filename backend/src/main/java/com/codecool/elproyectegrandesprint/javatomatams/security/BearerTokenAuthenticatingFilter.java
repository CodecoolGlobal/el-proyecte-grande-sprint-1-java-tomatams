package com.codecool.elproyectegrandesprint.javatomatams.security;

import com.codecool.elproyectegrandesprint.javatomatams.model.Client;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class BearerTokenAuthenticatingFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "LOPOTTLACI";

    private final TokenUtil tokenUtil;

    public BearerTokenAuthenticatingFilter(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer")) {
            // this is not a bearer token based authorization, so we let other filters
            // perform the authentication, if they can:
            filterChain.doFilter(request, response);
            return;
        }

        UserDetails client = tokenUtil.parseToken(token);

        if (client == null) {
            throw new BadCredentialsException("invalid token found in Authorization header");
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                "UserRegistrationApi", "", client.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
