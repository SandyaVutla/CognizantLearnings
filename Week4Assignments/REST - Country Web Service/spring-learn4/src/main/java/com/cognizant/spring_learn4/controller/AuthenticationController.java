package com.cognizant.spring_learn4.controller;

import java.util.*;
import java.util.Base64;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.*;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        System.out.println("Authorization Header: " + authHeader);
        Map<String, String> map = new HashMap<>();
        String user = getUser(authHeader);
        String token = generateJwt(user);
        map.put("token", token);
        return map;
    }

    private String getUser(String authHeader) {
        String encoded = authHeader.substring(6); // Remove "Basic "
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedBytes); // user:pwd
        return decoded.split(":")[0]; // return user only
    }

    private String generateJwt(String user) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)); // 20 mins
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        return builder.compact();
    }
}
