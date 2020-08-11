package com.example.SpringTomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringTomcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTomcatApplication.class, args);
	}

}
