package com.pragma.powerup.infrastructure.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "dab51d0684f10152380150b0fb056b02b5f464ef40f685b93abe0089ff9f3e67";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 86400l;

    public static String createToken(String name, String email){
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(getSigantureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigantureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigantureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public<T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    public static Key getSigantureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(ACCESS_TOKEN_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
