package com.vietlong.sandbox.service;

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

  public String login(LoginRequest request) {
    User user = userRepo.findByUsername(request.getUsername());
    if (user == null) {
      throw new RuntimeException("User not found");
    }
    
    return null;
  }
}
