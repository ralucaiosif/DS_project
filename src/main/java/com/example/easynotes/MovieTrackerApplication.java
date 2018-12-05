package com.example.easynotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MovieTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTrackerApplication.class, args);
	}
}
