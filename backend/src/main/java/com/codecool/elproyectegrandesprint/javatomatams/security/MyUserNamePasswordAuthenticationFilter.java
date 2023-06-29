package com.codecool.elproyectegrandesprint.javatomatams.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.codecool.elproyectegrandesprint.javatomatams.model.Client;
import com.codecool.elproyectegrandesprint.javatomatams.model.LogInDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.*;

public class MyUserNamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String SECRET_KEY = "SECRET_KEY";

    private final CustomAuthenticationManager customAuthenticationManager;

    public MyUserNamePasswordAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response
    ) throws AuthenticationException {
        try {
            byte[] inputStreamBytes = StreamUtils.copyToByteArray(request.getInputStream());
            LogInDTO logInDTO = new ObjectMapper().readValue(inputStreamBytes, LogInDTO.class);

            return customAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            logInDTO.name(),
                            logInDTO.password(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String name = String.valueOf(authResult.getPrincipal());
        String password = String.valueOf(authResult.getCredentials());

        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        List<String> roles = new ArrayList<>(authorities.size());
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }

        System.out.println("Roles: " + roles);
        Client principal = Client.builder().name(name).password(password).build();

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());

        String accessToken = JWT.create()
                .withSubject(name)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withClaim("role", roles)
                .sign(algorithm);

        System.out.println("accessToken: " + accessToken);

        response.setHeader("Authorization", "Bearer " + accessToken);
    }

}
