package com.example.productserviceopenapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (info = @Info(title = "Product Service", version = "1.0"))
public class ProductServiceOpenApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceOpenApiApplication.class, args);
    }

}
