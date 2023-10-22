package com.ajsw.barInventory.config;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("Bar-Inventory").version("1.0.0")
                .license(new License().name("Lincencia de Sistemas").url("www.bar.com"))
        );
    }
}

