package com.chegg.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.chegg" })
public class CheggProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheggProjectApplication.class, args);
	}

}
