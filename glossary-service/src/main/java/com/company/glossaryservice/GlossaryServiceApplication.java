package com.company.glossaryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GlossaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlossaryServiceApplication.class, args);
	}

}
