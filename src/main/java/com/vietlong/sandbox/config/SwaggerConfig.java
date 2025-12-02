package com.vietlong.sandbox.config;

import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Oxford3000 API")
            .version("1.0"));
  }

  @Bean
  public ModelResolver modelResolver(ObjectMapper objectMapper) {
    return new ModelResolver(objectMapper);
  }
  
}
