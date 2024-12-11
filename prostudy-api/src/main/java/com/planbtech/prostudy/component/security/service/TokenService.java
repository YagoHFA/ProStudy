    package com.planbtech.prostudy.component.security.service;


    import com.auth0.jwt.JWT;
    import com.auth0.jwt.algorithms.Algorithm;
    import com.auth0.jwt.exceptions.JWTCreationException;
    import com.auth0.jwt.exceptions.JWTVerificationException;
    import com.planbtech.prostudy.entities.model.User;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Service;

    import java.time.Instant;
    import java.time.LocalDateTime;
    import java.time.ZoneId;

    @Service
    public class TokenService {

        @Value("${api.security.token.secret}")
        private String secret;

        public String generateToken(User user) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                return JWT.create()
                        .withIssuer("prostudy-api")
                        .withSubject(user.getUsername())
                        .withExpiresAt(genExpirationDate())
                        .sign(algorithm);
            }
            catch (JWTCreationException e) {
                throw new RuntimeException("Error while generate new token", e);
            }
        }

        public String validateToken(String token) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                return JWT.require(algorithm)
                        .withIssuer("prostudy-api")
                        .build()
                        .verify(token)
                        .getSubject();
            }
            catch (JWTVerificationException e) {
                return "";
            }

        }

        private Instant genExpirationDate() {
            return LocalDateTime.now().plusHours(2).atZone(ZoneId.systemDefault()).toInstant();
        }
    }
