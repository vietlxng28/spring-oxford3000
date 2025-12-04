package com.vietlong.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vietlong.sandbox.entity.Permissions;

public interface PermissionsRepository extends JpaRepository<Permissions, Long> {

  @Query(value = "SELECT p.* FROM oxford3000.permissions p " +
      "JOIN oxford3000.user_permissions up ON p.id = up.permission_id " +
      "WHERE up.user_id = ?1", nativeQuery = true)
  java.util.List<Permissions> findPermissionsByUserId(Long userId);

}
