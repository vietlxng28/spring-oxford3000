package com.vietlong.sandbox.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

  @Schema(description = "Username for login. Example: admin")
  @NotEmpty(message = "Username is required")
  private String username;

  @Schema(description = "Password for login. Example: 123456")
  @NotEmpty(message = "Password is required")
  private String password;
}
