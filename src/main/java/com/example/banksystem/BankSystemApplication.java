package com.example.banksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSystemApplication.class, args);
	}

}
