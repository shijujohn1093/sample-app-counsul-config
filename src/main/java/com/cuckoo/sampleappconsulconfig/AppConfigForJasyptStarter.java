package com.cuckoo.sampleappconsulconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cuckoo.sampleappconsulconfig.service.EncryptionService;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@Configuration
@EncryptablePropertySource(value = "encrypted-keys.properties")
public class AppConfigForJasyptStarter {
	
	@Bean(name = "encryptorBean")
	public EncryptionService encryptionService() {
		return new EncryptionService();
	}
}