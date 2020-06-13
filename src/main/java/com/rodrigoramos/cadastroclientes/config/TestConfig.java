package com.rodrigoramos.cadastroclientes.config;

import com.rodrigoramos.cadastroclientes.service.impl.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@AllArgsConstructor
@Configuration
@Profile("test")
public class TestConfig {

    private final DatabaseService dbService;

    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateDatabase();
        return true;
    }
}
