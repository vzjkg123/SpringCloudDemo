package com.example.common.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class JwtUtils {
    public static String createToken(String secretKey, Map<String, Object> header, Map<String, Object> claims, Date expireDate) {
        if (Objects.isNull(claims)) {
            log.info("载荷内容[claims]为空");
            return null;
        }
        try {
            Key key = new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS512.getJcaName());
            JwtBuilder builder = Jwts.builder().addClaims(claims);
            if (Objects.nonNull(header)) {
                builder.setHeader(header);
            }
            if (Objects.nonNull(expireDate)) {
                builder.setExpiration(expireDate);
            }

            return builder.signWith(key).compact();
        } catch (Exception e) {
            log.error("Generate JWT Token error", e);
            System.out.println(e);
        }
        return null;
    }

    public static Claims decodeToken(String secretKey,String token){
        try{
            Key key = new SecretKeySpec(secretKey.getBytes(),SignatureAlgorithm.HS512.getJcaName());
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

        }catch (Exception e){
            log.error("Analyze JWT Token error",e);
        }
        return null;
    }
}
