package com.community.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.community.common", "com.community","com.community.fo.jpa.repository.BoardRepository"})
@Configuration
@EnableJpaRepositories("com.community.fo.jpa.repository")
@EntityScan("com.community.fo.jpa.entity")
//@MapperScan("com.community.fo.mybatis.mapper")
public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
