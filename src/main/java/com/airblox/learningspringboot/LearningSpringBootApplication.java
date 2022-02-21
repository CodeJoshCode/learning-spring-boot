package com.airblox.learningspringboot;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningSpringBootApplication {

	private static final Logger logger = LoggerFactory.getLogger(LearningSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootApplication.class, args);
		logger.info("This is an INFO message...");
	}

	// Runs on start up. Collects all the beans and prints them to standard output 
	// for analysis.
	// @Bean commenting out to stop printing behavior on startup
	public CommandLineRunner commandLineRunner(ApplicationContext context){
		return (args) -> {
			System.out.println("Let's inspect the beans provided by Spring Boot");

			// Get generated bean names from the application context
			String[] beanNames = context.getBeanDefinitionNames();
			// Bean names are not added in the same order every time
			// Sort them alphabetically for clarity
			Arrays.sort(beanNames);
			for(String beanName : beanNames){
				System.out.println(beanName);
			}
		};
	}

}
