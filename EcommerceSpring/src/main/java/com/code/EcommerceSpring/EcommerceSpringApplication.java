package com.code.EcommerceSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.code")
public class EcommerceSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
