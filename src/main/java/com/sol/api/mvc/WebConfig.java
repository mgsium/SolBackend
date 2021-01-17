package com.sol.api.mvc;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
        	.addMapping("/**")
        	.allowedOrigins("http://localhost:8080")
        	.allowCredentials(true)
        	.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "ALTER", "OPTIONS");
    }
	
}
