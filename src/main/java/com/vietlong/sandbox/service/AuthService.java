package com.vietlong.sandbox.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vietlong.sandbox.dto.request.LoginRequest;
import com.vietlong.sandbox.dto.response.TokenResponse;
import com.vietlong.sandbox.entity.Permissions;
import com.vietlong.sandbox.entity.User;
import com.vietlong.sandbox.repository.PermissionsRepository;
import com.vietlong.sandbox.repository.UserRepository;
import com.vietlong.sandbox.util.SecurityUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {
  private final UserRepository userRepo;
  private final SecurityUtils securityUtils;
  private final RedisTemplate<String, Object> redisTemplate;
  private final PermissionsRepository permissionsRepository;

  public TokenResponse login(LoginRequest request) {
    User user = userRepo.findByUsername(request.getUsername());
    if (user == null) {
      throw new RuntimeException("User not found");
    }

    // TO DO : check password

    String accessToken = securityUtils.generateAccessToken(user.getId(), user.getUsername());
    String refreshToken = securityUtils.generateRefreshToken(user.getId(), user.getUsername());

    String rediskey = "SEC:PERMISSION:" + user.getId();
    List<Permissions> permissions = permissionsRepository.findPermissionsByUserId(user.getId());
    redisTemplate.opsForValue().set(rediskey, permissions, securityUtils.getRefreshExpiration(), TimeUnit.MILLISECONDS);

    TokenResponse tokenResponse = TokenResponse.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .tokenType("Bearer")
        .expiresIn(securityUtils.getAccessExpiration() / 1000)
        .build();

    return tokenResponse;
  }
}
