package com.MyProject.e_commerce.Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.MyProject.e_commerce"})
@ComponentScan(basePackages = {"com.MyProject.e_commerce"})
@EnableJpaRepositories(basePackages = {"com.MyProject.e_commerce"})
@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
