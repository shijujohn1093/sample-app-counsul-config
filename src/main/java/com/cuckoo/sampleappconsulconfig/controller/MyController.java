package com.cuckoo.sampleappconsulconfig.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuckoo.sampleappconsulconfig.config.KafkaProperties;
import com.cuckoo.sampleappconsulconfig.config.MyConfig;

@EnableConfigurationProperties(value = MyConfig.class)
@RestController
public class MyController {

	@Autowired
	private MyConfig config;

	@Autowired
	private KafkaProperties kafkaProperties;

	@Value("${firstname}")
	private String firstName;
	
	@Value("${secondname}")
	private String secondName;
	
	@Value("${thirdname}")
	private String thirdName;
	
	@Value("${fourthname}")
	private String fourthName;
	
	@Value("${fifthname}")
	private String fifthName;

	@Autowired
	private Environment environment;
	
	
	

	// First way of getting configuration
	@GetMapping("/configs")
	public MyConfig getConfiguration() {
		return config;
	}

	// Second way of getting configuration
	@GetMapping("/envconfigs")
	public String getConfigurationFromEnv() {
		return environment.getProperty("thirdname");
	}

	// Third way of getting configuration
	@GetMapping("/names")
	public String testOldWay() {
		return firstName+ " ~ " +secondName+ " ~ " +thirdName+ " ~ " +fourthName+ " ~ " +fifthName;
	}

	// Fourth way of getting configuration
	@GetMapping("/kafkaconsumerconfigs")
	public Map<String, Object> getKafkaConsumerConfiguration() {
		return kafkaProperties.getConsumer();
	}

	@GetMapping("/kafkaproducerconfigs")
	public Map<String, Object> getKafkaProducerConfiguration() {
		return kafkaProperties.getProducer();
	}

}
