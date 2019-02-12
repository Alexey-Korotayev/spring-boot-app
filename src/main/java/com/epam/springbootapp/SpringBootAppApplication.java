package com.epam.springbootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootAppApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		System.out.println("Start ");
		LOGGER.info("Message {}", "Start log");
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}

