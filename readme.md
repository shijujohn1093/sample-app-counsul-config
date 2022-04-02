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
* Environemnt specific configs from consul


## Set key value on Harshicorp Consul
Run below command from same location where consul.exe is present. It will add key/valaue 

### Set key value for sample-app-consul-config application for all environments
	consul kv put config/sample-app-consul-config/jdbcconnection default_jdbc_conn_for_all_env_for_sample_app
	consul kv put config/sample-app-consul-config/user.username shijujohn
	consul kv put config/sample-app-consul-config/user.password password1234
	consul kv put config/sample-app-consul-config/firstname shiju_1_allenv_sample_app
	consul kv put config/sample-app-consul-config/secondname shiju_2_allenv_sample_app
	consul kv put config/sample-app-consul-config/thirdname shiju_3_allenv_sample_app
	consul kv put config/sample-app-consul-config/fourthname shiju_4_allenv_sample_app
	consul kv put config/sample-app-consul-config/fifthname shiju_5_allenv_sample_app
	consul kv put config/sample-app-consul-config/domain.kafka.consumer.[bootstrap.servers] localhost:29092
	consul kv put config/sample-app-consul-config/domain.kafka.consumer.[group.id] adults
	consul kv put config/sample-app-consul-config/domain.kafka.consumer.[auto.offset.reset] earliest
	consul kv put config/sample-app-consul-config/domain.kafka.consumer.[key.deserializer] org.apache.kafka.common.serialization.StringDeserializer
	consul kv put config/sample-app-consul-config/domain.kafka.consumer.[value.deserializer] org.apache.kafka.common.serialization.StringDeserializer
	consul kv put config/sample-app-consul-config/domain.kafka.producer.[bootstrap.servers] localhost:29092
	consul kv put config/sample-app-consul-config/domain.kafka.producer.[key.serializer] org.apache.kafka.common.serialization.StringSerializer
	consul kv put config/sample-app-consul-config/domain.kafka.producer.[value.serializer] org.apache.kafka.common.serialization.StringSerializer
	
### Set key value for sample-app-consul-config application for dev environment
	consul kv put config/sample-app-consul-config,dev/firstname shiju_1_dev_sample_app
	
Note : Make sure spring.profile.active=dev in application property or passed as argument
	
### Set key value applicable for all applications of all environments	
	consul kv put config/application/firstname shiju_1_allenv_allapp
	consul kv put config/application/thirdname shiju_3_allenv_allapp
	consul kv put config/application/fourthname shiju_4_allenv_allapp
	consul kv put config/application/fifthname shiju_5_allenv_allapp
	
### Set key value applicable for all applications of dev environment
	consul kv put config/application,dev/firstname shiju_1_devenv_allapp
	consul kv put config/application,dev/thirdname shiju_3_devenv_allapp
	consul kv put config/application,dev/fourthname shiju_4_devenv_allapp
	consul kv put config/application,dev/fifthname shiju_5_devenv_allapp
	
	
### Test your application, validate value of varibale picked from various places

http://localhost:8080/names