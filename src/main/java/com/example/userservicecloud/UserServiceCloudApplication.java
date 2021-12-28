package com.example.userservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceCloudApplication.class, args);
	}

}
