package com.promeethub_api.api.configs.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.promeethub_api.domain.entities.UserEntity;
import com.promeethub_api.domain.enums.UserRole;
import com.auth0.jwt.JWT;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.time.Instant;

@RequiredArgsConstructor
@Component
public class JWTProvider {

    //Signature
    private static final String JWT_SECRET = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMzIwNzEwMCwiZXhwIjoxNjIzMjA3MTMwfQ.";
    //Delai de validité
    private static final long EXPIRES_AT = 86400; // 1 jour
    //Nom en tête
    private static final String AUTH_HEADER = "Authorization";
    //type
    private static final String TOKEN_PREFIX = "Bearer ";// avec espace
    private  final UserDetailsService userDetailsService;

    //Methode de generation de token
    public String generateToken(String email, UserRole role){
        return TOKEN_PREFIX + JWT.create()
                .withSubject(email)
                .withClaim("role", role.toString())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusMillis(EXPIRES_AT))
                .sign(Algorithm.HMAC512(JWT_SECRET));
    }
    //Methode d'extraction du token, à partir de la requete
    public String extractToken(HttpServletRequest request){
        String header = request.getHeader(AUTH_HEADER);

        if(header == null || !header.startsWith(TOKEN_PREFIX)){
            return null;
        }
        return header.replaceFirst(TOKEN_PREFIX, "");
    }

    //Methode de validation de token
    public boolean validateToken(String token){
        try {

            //1 le bon JWT_SECRET à été utilisé (le même algorithme de cryptage)
            //2 token n'est pas expiré
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512(JWT_SECRET))
                    .acceptExpiresAt(EXPIRES_AT)
                    .withClaimPresence("sub")
                    .withClaimPresence("role")
                    .build()
                    .verify(token);

            //3 token créé a partir d'un User existant et actif
            String email = jwt.getSubject();
            UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(email);

            //4 les roles soient bons (on ne le fait pas tout le temps)
            UserRole role = UserRole.valueOf(jwt.getClaim("role").asString());

            return user.getRole().equals(role);

        }
        catch (JWTVerificationException | UsernameNotFoundException e){
            return false;
        }
    }
    //Methode de creation de l'Authentication
    public Authentication createAuthentication(String token){
        DecodedJWT jwt = JWT.decode(token);

        String email = jwt.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                null,//on peut rajouter le token aussi pour un refresh token (le refresh token c'est pour étendre la session on regénère un token)
                userDetails.getAuthorities()
        );
    }


}
