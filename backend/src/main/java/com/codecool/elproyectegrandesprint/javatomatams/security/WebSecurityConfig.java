package com.codecool.elproyectegrandesprint.javatomatams.security;

import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
@EnableWebSecurity(debug = false)
public class WebSecurityConfig {

    private final ClientRepository clientRepository;

    @Autowired
    public WebSecurityConfig(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.DELETE, "/recipes/delete/{id}")
                        .hasRole("ADMIN")
                        .requestMatchers("/recipes/add")
                        .hasRole("USER")
                        .requestMatchers("/", "/recipes/all", "/recipes/search", "/users/add", "/recipes/{id}")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .addFilterAfter(myUserNamePasswordAuthenticationFilter(), ExceptionTranslationFilter.class)
                .addFilterAfter(bearerTokenAuthenticatingFilter(), ExceptionTranslationFilter.class)
        ;
        return http.build();
    }
    @Bean
    public AuthenticationManager customAuthenticationManager(){
        return new CustomAuthenticationManager(clientDetailsService(), passwordEncoder());
    }

    @Bean
    public MyUserNamePasswordAuthenticationFilter myUserNamePasswordAuthenticationFilter (){
        return new MyUserNamePasswordAuthenticationFilter(customAuthenticationManager());
    }

    @Bean
    public ClientDetailsService clientDetailsService(){
        return new ClientDetailsService(clientRepository);
    }

    @Bean
    public BearerTokenAuthenticatingFilter bearerTokenAuthenticatingFilter(){
        return new BearerTokenAuthenticatingFilter(tokenUtil());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenUtil tokenUtil (){
        return new TokenUtil(clientDetailsService());
    }
}
