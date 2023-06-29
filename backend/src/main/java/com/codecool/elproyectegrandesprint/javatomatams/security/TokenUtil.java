package com.codecool.elproyectegrandesprint.javatomatams.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    private final String SECRET_KEY = "LOPOTTLACI";

    private ClientDetailsService clientDetailsService;

    @Autowired
    public TokenUtil(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    public UserDetails parseToken(String token) {

        try {

            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            String clientName = body.getSubject();
            System.out.println("ClientName: " + clientName);
            return clientDetailsService.loadUserByUsername(clientName);

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }
}
