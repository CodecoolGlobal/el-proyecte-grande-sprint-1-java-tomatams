package com.codecool.elproyectegrandesprint.javatomatams.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    private final ClientDetailsService clientDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationManager(ClientDetailsService clientDetailsService, PasswordEncoder passwordEncoder) {
        this.clientDetailsService = clientDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Authentication auth = null;
        UserDetails client = clientDetailsService.loadUserByUsername(name);

        if (passwordEncoder.matches( password, client.getPassword())) {
            auth = new UsernamePasswordAuthenticationToken(
                    name, password, client.getAuthorities());
            System.out.println("auth: " + auth);
        }
        return auth;
    }


}


