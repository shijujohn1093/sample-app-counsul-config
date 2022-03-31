package com.cuckoo.sampleappconsulconfig.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@ConfigurationProperties("domain.kafka")
@Getter
@Configuration
public class KafkaProperties {	
	private final Map<String, Object> consumer = new HashMap<String, Object>();
	private final Map<String, Object> producer = new HashMap<String, Object>();	
}