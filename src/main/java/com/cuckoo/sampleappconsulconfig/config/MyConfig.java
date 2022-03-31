package com.cuckoo.sampleappconsulconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "user")
public class MyConfig {

	private String username;
	private String password;
	
	
}
