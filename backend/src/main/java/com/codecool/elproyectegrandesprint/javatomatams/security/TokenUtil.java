package com.codecool.elproyectegrandesprint.javatomatams.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
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
        String splitToken = token.substring(7);

        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());

            JWTVerifier verifier = JWT.require(algorithm)
                    .build();

            DecodedJWT jwt = verifier.verify(splitToken);

            String clientName = jwt.getSubject();
            return clientDetailsService.loadUserByUsername(clientName);

        } catch (JwtException | ClassCastException e) {
            System.out.println(e);
            return null;
        }
    }
}
