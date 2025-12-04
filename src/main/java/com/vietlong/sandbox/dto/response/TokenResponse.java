package com.vietlong.sandbox.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
public class TokenResponse {
  @Schema(description = "The JWT access token")
  private String accessToken;

  @Schema(description = "The refresh token for obtaining new access tokens")
  private String refreshToken;

  @Schema(description = "The type of token, typically 'Bearer'")
  private String tokenType;

  @Schema(description = "The number of seconds until the access token expires")
  private Long expiresIn;
}
