package com.ace.springsecuritydemo.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	private String secretKey = "";
	
	public JWTService() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey = keyGenerator.generateKey();
			this.secretKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.claims(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() +60*60*30))
				.signWith(getKey())
				.compact();
	}
	
	public SecretKey getKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

	public String extractUserName(String token) {
		final Claims claims = extractAllClaims(token);
		return claims.getSubject();
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		
	}
}
