package com.community.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.community.fo.service"})
@ComponentScan(basePackages = {"com.community.common", "com.community","com.community.fo.jpa.repository","com.community.fo.service"})
@Configuration
@EnableJpaRepositories("com.community.fo.jpa.repository")
@EntityScan(basePackages = "com.community.fo.jpa.entity")
public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

	

	
}
