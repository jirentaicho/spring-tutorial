package com.volkruss.tutorialstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TutorialstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialstudyApplication.class, args);
	}

}
