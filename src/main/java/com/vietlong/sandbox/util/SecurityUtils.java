package com.vietlong.sandbox.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;

@Getter
@Component
public class SecurityUtils {
  @Value("${security.jwt.secret}")
  private String secretKey;

  @Value("${security.jwt.access-expiration:900000}")
  private long accessExpiration;

  @Value("${security.jwt.refresh-expiration:604800000}")
  private long refreshExpiration;


  // Tạo access token (JWT) cho người dùng
  public String generateAccessToken(Long userId, String username) {
    return buildToken(userId, username, accessExpiration);
  }

  // Tạo refresh token cho người dùng
  public String generateRefreshToken(Long userId, String username) {
    return buildToken(userId, username, refreshExpiration);
  }

  // Hàm xây dựng JWT token với thông tin userId, username và thời gian hết hạn
  private String buildToken(Long userId, String username, long expiration) {
    String token = Jwts.builder()
        .setSubject(username)                 // Đặt username vào subject
        .claim("uid", userId)                 // Lưu userId trong claim "uid"
        .setIssuedAt(new Date())              // Thời gian phát hành token
        .setExpiration(new Date(System.currentTimeMillis() + expiration)) // Thời gian hết hạn
        .signWith(SignatureAlgorithm.HS512, secretKey)  // Ký bằng HMAC512 và secretKey
        .compact();
    return token;
  }

  // Trích xuất claims từ JWT token
  public Claims extractClaims(String token) {
    return Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(token)
        .getBody();
  }

  // Kiểm tra tính hợp lệ của token
  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      // Token không hợp lệ (sai chữ ký, hết hạn, v.v.)
      return false;
    }
  }
}
