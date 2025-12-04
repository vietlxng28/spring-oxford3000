package com.vietlong.sandbox.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vietlong.sandbox.entity.Permissions;
import com.vietlong.sandbox.repository.PermissionsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Tag(name = "Sandbox", description = "Sandbox API")
@AllArgsConstructor
@RequestMapping("/sandbox")
@RestController
public class SandboxController {
  private final PermissionsRepository permissionsRepository;

  @GetMapping("{userId}/permissions")
  public Set<Permissions> getPermissionsByUserId(@PathVariable Long userId) {
      List<Permissions> permissionsList = permissionsRepository.findPermissionsByUserId(userId);
      return new HashSet<>(permissionsList);
  }
  
}
