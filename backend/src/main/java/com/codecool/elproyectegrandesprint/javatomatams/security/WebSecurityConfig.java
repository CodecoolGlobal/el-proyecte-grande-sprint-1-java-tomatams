package com.codecool.elproyectegrandesprint.javatomatams.security;

import com.codecool.elproyectegrandesprint.javatomatams.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig {

    private final CustomAuthenticationManager authenticationManager;

    private final BearerTokenAuthenticatingFilter bearerTokenAuthenticatingFilter;

    @Autowired
    public WebSecurityConfig(CustomAuthenticationManager authenticationManager, BearerTokenAuthenticatingFilter bearerTokenAuthenticatingFilter) {
        this.authenticationManager = authenticationManager;
        this.bearerTokenAuthenticatingFilter = bearerTokenAuthenticatingFilter;
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/users/add")
                                .hasRole("ADMIN")
                .requestMatchers("/**")
                .permitAll()
                )
                .addFilterAfter( new MyUserNamePasswordAuthenticationFilter(authenticationManager), ExceptionTranslationFilter.class)
                .addFilterAfter(bearerTokenAuthenticatingFilter, ExceptionTranslationFilter.class)
        ;
    return http.build();
    }

}
