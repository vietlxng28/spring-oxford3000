package com.vietlong.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vietlong.sandbox.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
  User findByUsername(String username);
  
}
