package com.api.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiproductosApplication {

    public static void main(String[] args) {
            SpringApplication.run(ApiproductosApplication.class, args);
    }


    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/api/**")
                            .allowedOrigins("http://localhost:5173",
                                    "https://d733-190-107-235-168.ngrok-free.app",
                                    "http://localhost:8081",
                                    "http://aplicaciones.uteq.edu.ec:9029",
                                    "http://192.168.0.106:8082")
                            .allowedMethods("GET", "POST", "PUT", "DELETE")
                            .allowedHeaders("*")
                            .allowCredentials(true);

            }
        };
    }
       

}
