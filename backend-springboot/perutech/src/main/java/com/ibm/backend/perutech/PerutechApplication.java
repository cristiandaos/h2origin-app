package com.ibm.backend.perutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class PerutechApplication {
    public static void main(String[] args) {
        SpringApplication.run(PerutechApplication.class, args);
    }
}
