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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MyUserNamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String SECRET_KEY = "SECRET_KEY";

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response
    ) throws AuthenticationException {
        try {
            byte[] inputStreamBytes = StreamUtils.copyToByteArray(request.getInputStream());
            LogInDTO logInDTO = new ObjectMapper().readValue(inputStreamBytes, LogInDTO.class);
            AuthenticationManager authenticationManager = getAuthenticationManager();
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
        // TODO - create JWT token
        //super.successfulAuthentication(request, response, chain, authResult);
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }

        Client principal = (Client) authResult.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());

        String accessToken = JWT.create()
                .withSubject(principal.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withClaim("role", principal.getRole().ordinal())
                .sign(algorithm);

        System.out.println(accessToken);

        response.setHeader("Authorization", "Bearer " + accessToken);

        //response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //new ObjectMapper().writeValue(response.getOutputStream(), accessToken);
    }

}
