package com.vietlong.sandbox.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vietlong.sandbox.dto.request.LoginRequest;
import com.vietlong.sandbox.entity.User;
import com.vietlong.sandbox.repository.UserRepository;
import com.vietlong.sandbox.util.SecurityUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
  private final UserRepository userRepo;
  private final SecurityUtils securityUtils;
  private final RedisTemplate<String, Object> redisTemplate;

  public String login(LoginRequest request) {
    User user = userRepo.findByUsername(request.getUsername());
    if (user == null) {
      throw new RuntimeException("User not found");
    }
    
    // TO DO : check password

    String accessToken = securityUtils.generateAccessToken(user.getId(), user.getUsername());
    String refreshToken = securityUtils.generateRefreshToken(user.getId(), user.getUsername());

  String rediskey = "SEC:PERMISSION:" + user.getId();
  

    return null;
  }
}
