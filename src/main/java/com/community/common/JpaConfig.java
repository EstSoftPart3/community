package com.community.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.community.fo.jpa.repository")
@EntityScan(basePackages = "com.community.fo.jpa.entity")
public class JpaConfig {



	
}
