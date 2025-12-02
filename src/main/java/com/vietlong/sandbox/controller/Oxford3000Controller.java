package com.vietlong.sandbox.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import com.vietlong.sandbox.dto.response.ApiResponse;
import com.vietlong.sandbox.service.Oxford3000Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Oxford3000", description = "Oxford3000 API")
@AllArgsConstructor
@RequestMapping("/oxford3000")
@RestController
public class Oxford3000Controller {

  private final Oxford3000Service oxford3000Service;

  @Operation(summary = "Get all Oxford3000 class of word")
  @GetMapping("/class-of-word")
  public ResponseEntity<ApiResponse<List<String>>> getAllOxford3000ClassOfWord(HttpServletRequest request) {
    String path = request.getRequestURI();
    List<String> classOfWord = oxford3000Service.getAllOxford3000ClassOfWord();
    ApiResponse<List<String>> response = ApiResponse
        .<List<String>>builder()
        .data(classOfWord)
        .path(path)
        .status(HttpStatus.OK.value())
        .message("Success")
        .build();
    return ResponseEntity.ok(response);
  }

  @Operation(summary = "Get all Oxford3000 level")
  @GetMapping("/level")
  public ResponseEntity<ApiResponse<List<String>>> getAllOxford3000Level(HttpServletRequest request) {
    String path = request.getRequestURI();
    List<String> level = oxford3000Service.getAllOxford3000Level();
    ApiResponse<List<String>> response = ApiResponse
        .<List<String>>builder()
        .data(level)
        .path(path)
        .status(HttpStatus.OK.value())
        .message("Success")
        .build();
    return ResponseEntity.ok(response);
  }
}
