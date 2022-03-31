## spring-cloud-consul
how to centralize configuration using spring cloud consul
Download consul :  https://www.consul.io/downloads.html
Commands:
Check IP : ipconfig
bootstrap consul : consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=YOUR_IP_ADDRESS

consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.1.89

Open browser

http://127.0.0.1:8500/

## Get Key directly from Consul: 
http://localhost:8500/v1/kv/config/sample-app-counsul-config/user.username


## Spring Cloud Documentation:

https://docs.spring.io/spring-cloud-consul/docs/current/reference/html/#distributed-configuration-usage

https://docs.spring.io/spring-cloud-consul/docs/current/reference/html/#config-data-import


## Open Questions

* Need to check how to cache configuration do not reload from consul
* How to make sure that latest config picked up form consul
* Test various way of configuration


## Property Samples
Following are the properties to be added in consul key/value:


        	config/sample-app-counsul-config/user.username=shijujohn
        	config/sample-app-counsul-config/password=password1234
			config/sample-app-counsul-config/thirdname=shiju333
			config/sample-app-counsul-config/fourthname=shiju444
			config/sample-app-counsul-config/domain.kafka.consumer.[bootstrap.servers]=localhost:29092
			config/sample-app-counsul-config/domain.kafka.consumer.[group.id]=adults
			config/sample-app-counsul-config/domain.kafka.consumer.[auto.offset.reset]=earliest
			config/sample-app-counsul-config/domain.kafka.consumer.[key.deserializer]=org.apache.kafka.common.serialization.StringDeserializer
			config/sample-app-counsul-config/domain.kafka.consumer.[value.deserializer]=org.apache.kafka.common.serialization.StringDeserializer
			config/sample-app-counsul-config/domain.kafka.producer.[bootstrap.servers]=localhost:29092
			config/sample-app-counsul-config/domain.kafka.producer.[key.serializer]=org.apache.kafka.common.serialization.StringSerializer
			config/sample-app-counsul-config/domain.kafka.producer.[value.serializer]=org.apache.kafka.common.serialization.StringSerializer