package com.example.viaCep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class ViaCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViaCepApplication.class, args);
	}

}
