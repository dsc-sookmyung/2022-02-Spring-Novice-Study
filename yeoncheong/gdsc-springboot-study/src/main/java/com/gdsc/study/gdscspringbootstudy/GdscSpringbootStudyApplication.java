package com.gdsc.study.gdscspringbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class GdscSpringbootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdscSpringbootStudyApplication.class, args);
	}

}
