package com.atharva.ComplianceManager.jwt;

import com.atharva.ComplianceManager.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${spring.app.jwtSecret}")
    private String SECRET_KEY;

    @Value("${spring.app.jwtExpirationMs}")
    private Long EXPIRATION_TIME;

    //✅ Extract username kiva email
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }


    //✅extract expiration date
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }


    //✅Generic claim extractor
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //✅Generate token(add role as claim)
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        //add role claims
        claims.put("roles", userDetails.getAuthorities().iterator().next().getAuthority());
        claims.put("username", userDetails.getUsername());
        return createToken(claims, userDetails.getUsername());
    }

    //✅create token for settingPassword(no expiry)
    public String generateSetPasswordToken(User user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("username", user.getEmail());
        claims.put("fullname", user.getFirstName()+" "+user.getLastName());
        claims.put("purpose","SET_PASSWORD");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUserName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000L * 60 * 60 * 26))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

    //✅validate token
    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    //✅internal helpers
    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().claims(claims).subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build().parseSignedClaims(token).getPayload();
    }
}
