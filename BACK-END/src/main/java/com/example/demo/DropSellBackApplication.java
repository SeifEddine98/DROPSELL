package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan( basePackages = {"ENTITIES"})
@ComponentScan( basePackages = {"CONTROLLERS","METIER","SERVICE"})
@EnableJpaRepositories( basePackages = {"DAO"})
public class DropSellBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropSellBackApplication.class, args);

	}

}
