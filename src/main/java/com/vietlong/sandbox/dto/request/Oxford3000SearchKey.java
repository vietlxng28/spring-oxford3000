package com.vietlong.sandbox.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Oxford3000SearchKey {

  @Schema(description = "Class of word for Oxford3000 entry. Example: noun, verb, adjective.")
  @NotEmpty(message = "Class of word is required")
  String classOfWord;

  @Schema(description = "Level of the word according to Oxford3000 list. Example: a1, a2, b1, b2.")
  @NotEmpty(message = "Level is required")
  String level;

}
