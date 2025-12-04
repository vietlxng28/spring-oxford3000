package com.vietlong.sandbox.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "Sandbox", description = "Sandbox API")
@AllArgsConstructor
@RequestMapping("/sandbox")
@RestController
public class SandboxController {
  
}
