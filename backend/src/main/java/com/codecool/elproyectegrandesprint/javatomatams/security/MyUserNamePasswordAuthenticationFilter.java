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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.security.Principal;
import java.util.*;


public class MyUserNamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String SECRET_KEY = "SECRET_KEY";

    public MyUserNamePasswordAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }

    private final CustomAuthenticationManager customAuthenticationManager;



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response
    ) throws AuthenticationException {
        try {
            byte[] inputStreamBytes = StreamUtils.copyToByteArray(request.getInputStream());
            LogInDTO logInDTO = new ObjectMapper().readValue(inputStreamBytes, LogInDTO.class);
            System.out.println(logInDTO.name() + " " + logInDTO.password());
            AuthenticationManager authenticationManager = customAuthenticationManager;
            return authenticationManager.authenticate(
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
        Collection authorities = authResult.getAuthorities();
        List roles = new ArrayList<>();
        Client principal = Client.builder().name(name).password(password).build();

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());

        String accessToken = JWT.create()
                .withSubject(name)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withClaim("role", "USER")
                .sign(algorithm);

        System.out.println(accessToken);

        response.setHeader("Authorization", "Bearer " + accessToken);

        //response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //new ObjectMapper().writeValue(response.getOutputStream(), accessToken);
    }

}
