package com.facebook.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*")
//                        .allowedOrigins("http://127.0.0.1:5500",
//                                "http://localhost:8080", "http://www.devchat.me",
//                                "https://vnexpress.net")
                        .allowedHeaders("*")
                    .allowCredentials(true);
            }
        };
    }
}
