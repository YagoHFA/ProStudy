package com.planbtech.prostudy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default server URL")})
@SpringBootApplication
public class ProstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProstudyApplication.class, args);
    }

}
